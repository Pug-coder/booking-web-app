package com.example.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String home(
            Model model
    ) {
        System.out.println("Main method called!");
        model.addAttribute("some", "Let's go!");
        return "home";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World")
                               String name,
                           Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}