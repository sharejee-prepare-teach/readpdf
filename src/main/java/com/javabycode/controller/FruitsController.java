package com.javabycode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javabycode.model.Fruit;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/fruits")
public class FruitsController {

    List<Fruit> array = Arrays.asList(
            new Fruit(1, "Banana", "Indonesia"),
            new Fruit(2, "Orange", "Holland"),
            new Fruit(3, "Mango", "France")
    );

    @RequestMapping(method = RequestMethod.GET)
    public String getDocuments(Model model) {
        model.addAttribute("fruits", array);
        return "index";

    }
}
