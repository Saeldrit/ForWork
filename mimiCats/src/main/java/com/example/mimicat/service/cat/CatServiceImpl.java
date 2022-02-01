package com.example.mimicat.service.cat;

import com.example.mimicat.model.Cat;
import com.example.mimicat.model.Like;
import com.example.mimicat.repository.CatRepository;
import com.example.mimicat.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;
    private final LikeRepository likeRepository;

    @Override
    public List<Cat> getAll() {
        return catRepository.findAll().stream()
                .sorted(Comparator.comparing(Cat::getCatId))
                .collect(Collectors.toList());
    }

    @Override
    public Cat getById(Integer id) {
        return catRepository.getById(id);
    }

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
    public void deleteCat(Integer id) {
        catRepository.deleteById(id);
    }

    @Override
    public void countLike(Integer id) {
        Cat cat = catRepository.getById(id);
        cat.setCountLike(cat.getCountLike() + 1);
        updateCat(cat.getCatId(), cat);
    }

    @Override
    public List<Cat> getTwoCats() {
        List<Cat> cats = getAll();
        List<Cat> twoCats = new ArrayList<>();
        List<String> countDuplicates = countDuplicates(cats);

        while (likeRepository.count() != countDuplicates.size()) {
            int random = (int) (Math.random() * (countDuplicates.size() + 1) - 1);

            String duplicate = countDuplicates.get(random);
            Optional<Like> like = likeRepository.findLikeByCombination(duplicate);

            if (like.isEmpty()) {
                int[] array = getDuplicate(duplicate);

                twoCats.add(cats.get(array[0]));
                twoCats.add(cats.get(array[1]));

                likeRepository.save(Like.builder()
                        .combination(duplicate)
                        .build());
                break;
            }
        }
        return twoCats;
    }

    @Override
    public List<Cat> getTopCats() {
        likeRepository.deleteAll();

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

    private List<String> countDuplicates(List<Cat> cats) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < cats.size() - 1; i++) {
            for (int j = i + 1; j < cats.size(); j++) {
                if (i != j) {
                    list.add(i + "" + j);
                }
            }
        }
        return list;
    }

    private int[] getDuplicate(String combination) {
        int[] array = new int[2];

        int fromString = Integer.parseInt(combination);
        array[0] = fromString / 10;
        array[1] = fromString % 10;

        return array;
    }
}
