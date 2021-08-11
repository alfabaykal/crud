package com.alfabaykal.crud.controller;

import com.alfabaykal.crud.entity.User;
import com.alfabaykal.crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class AppController {

    private final UserService userService;

    public AppController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "all-users-view";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String updateUser(@PathVariable ("id") int id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "user-info";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {

        userService.deleteUser(id);

        return "redirect:/users";
    }

}
