package ru.kata.katacourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.katacourse.model.User;
import ru.kata.katacourse.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "main";
    }

    @GetMapping("/registration")
    public String addUser(Model model) {

        User user = new User();
        model.addAttribute("newUser", user);

        return "registration-user";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("newUser", user);

        return "registration-user";
    }

    @PostMapping()
    public String create(@ModelAttribute("newUser") User user) {

        userService.addUser(user);

        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {

        userService.removeUser(id);

        return "redirect:/user";
    }
}
