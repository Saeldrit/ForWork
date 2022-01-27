package com.example.mimicat.service.cat;

import com.example.mimicat.model.Cat;
import com.example.mimicat.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;
    private final List<String> bufferForDuplicates;

    @Override
    public void addCat(Cat cat) {
        catRepository.save(Cat.builder()
                .countLike(0)
                .name(cat.getName())
                .url(cat.getUrl())
                .rating(0)
                .build());
    }

    @Override
    public void deleteCat(Integer id) {
        catRepository.deleteById(id);
    }

    @Override
    public void updateCat(Integer id, Cat cat) {
        catRepository.save(getById(id)
                .toBuilder()
                .catId(id)
                .name(cat.getName())
                .url(cat.getUrl())
                .countLike(cat.getCountLike())
                .rating(cat.getRating())
                .build());
    }

    @Override
    public void countLike(Integer id) {
        Cat cat = catRepository.getById(id);
        cat.setCountLike(cat.getCountLike() + 1);
        updateCat(cat.getCatId(), cat);
    }

    @Override
    public Cat getById(Integer id) {
        return catRepository.getById(id);
    }

    @Override
    public List<Cat> getAll() {
        return catRepository.findAll().stream()
                .sorted(Comparator.comparing(Cat::getCatId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cat> getTwoCats() {
        List<Cat> listCat = getAll();
        List<Cat> twoCats;

        if (listCat.size() > 1) {
            twoCats = realizeGetTwoCats(listCat);
        } else {
            return listCat;
        }
        return twoCats;
    }

    @Override
    public List<Cat> getTopCats() {
        List<Cat> cats = getAll()
                .stream()
                .sorted(Comparator.comparing(Cat::getCountLike))
                .toList();

        if (cats.size() <= 10) {
            return writeRating(cats);
        } else {
            List<Cat> topCats = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                topCats.add(cats.get(i));
            }

            return writeRating(topCats);
        }
    }

    private List<Cat> writeRating(List<Cat> cats) {
        for (int i = cats.size() - 1; i >= 0; i--) {
            Cat cat = cats.get(i)
                    .toBuilder()
                    .rating(cats.size() - i)
                    .build();
            updateCat(cat.getCatId(), cat);
        }
        return cats.stream()
                .sorted(Comparator.comparing(Cat::getRating))
                .toList();
    }

    private List<Cat> realizeGetTwoCats(List<Cat> listCat) {
        List<Cat> twoCats = new ArrayList<>();
        List<String> duplicates = countDuplicates(listCat);
        int[] resultPair;

        for (int i = 0; i < duplicates.size(); i++) {
            String line = duplicates.get(i);
            int check = bufferForDuplicates.indexOf(line);

            if (check == -1) {
                resultPair = getDuplicate(duplicates, i);
                bufferForDuplicates.add(line);

                twoCats.add(listCat.get(resultPair[0]));
                twoCats.add(listCat.get(resultPair[1]));
                break;
            }
        }
        return twoCats;
    }

    private List<String> countDuplicates(List<Cat> cats) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < cats.size() - 1; i++) {
            for (int j = i + 1; j < cats.size(); j++) {
                if (i != j) {
                    list.add(i + " " + j);
                }
            }
        }
        return list;
    }

    private int[] getDuplicate(List<String> list, int index) {
        int[] array = new int[2];
        String line = list.get(index).replaceAll("\\s", "");

        int fromString = Integer.parseInt(line);
        array[0] = fromString / 10;
        array[1] = fromString % 10;

        return array;
    }
}
