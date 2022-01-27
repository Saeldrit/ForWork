package com.example.mimicat.controller;

import com.example.mimicat.model.Cat;
import com.example.mimicat.service.cat.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("/cats")
    public String getCatList(Model model) {
        List<Cat> cats = catService.getTwoCats();
        model.addAttribute("cats", cats);
        return "/cats/cats";
    }

    @GetMapping("/results")
    public String getResult(Model model) {
        List<Cat> cats = catService.getTopCats();
        model.addAttribute("cats", cats);
        return "cats/results";
    }

    @PostMapping("/cat-add")
    public String catAdd(Cat cat) {
        catService.addCat(cat);
        return "redirect:/cats";
    }

    @PostMapping("/cats/{cat-id}/delete")
    public String deleteCat(@PathVariable("cat-id") Integer id) {
        catService.deleteCat(id);
        return "redirect:/cats";
    }

    @PostMapping("/cats/{cat-id}/like")
    public String countLike(@PathVariable("cat-id") Integer id) {
        catService.countLike(id);
        return "redirect:/cats";
    }
}
