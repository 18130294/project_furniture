package com.example.furniture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {

    @GetMapping("/international")
    public String getInternationalPage() {
        return "test";
    }

}
