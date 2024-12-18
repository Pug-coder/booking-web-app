package com.example.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(
            Model model
    ) {
        model.addAttribute("some", "Let's go!");
        return "home";
    }

    @GetMapping("/main")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World")
                               String name,
                           Model model) {
        model.addAttribute("name", name);
        return "main";
    }

}