package com.example.mimicat.service.cat;

import com.example.mimicat.model.Cat;

import java.util.List;

public interface CatService {

    List<Cat> getTwoCats();

    List<Cat> getTopCats();

    Cat getById(Integer id);

    void updateCat(Integer id, Cat cat);

    void addCat(Cat cat);

    List<Cat> getAll();

    void deleteCat(Integer id);

    void countLike(Integer count);
}
