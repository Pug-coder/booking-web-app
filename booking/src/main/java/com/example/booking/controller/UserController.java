package com.example.booking.controller;

import com.example.booking.domain.User;
import com.example.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user"; // Шаблон add-user.html
    }

    @PostMapping(path="/add")
    public String addNewUser(@RequestParam String firstName, @RequestParam String lastName) {
        User n = new User();
        n.setFirstName(firstName);
        n.setLastName(lastName);
        userRepository.save(n);
        return "redirect:/users/all"; // Возврат шаблона add-user.html
    }

    @GetMapping(path="/all")
    public String getAllUsers(Model model) {
        // Добавляем всех пользователей в модель
        model.addAttribute("users", userRepository.findAll());
        return "user-list"; // Возврат шаблона user-list.html
    }
}


