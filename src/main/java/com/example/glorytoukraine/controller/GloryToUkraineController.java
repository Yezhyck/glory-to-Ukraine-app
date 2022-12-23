package com.example.glorytoukraine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GloryToUkraineController {

    @GetMapping("/glory")
    public String gloryToUkraine() {
        return "to Ukraine";
    }
}
