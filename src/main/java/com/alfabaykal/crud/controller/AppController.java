package com.alfabaykal.crud.controller;

import com.alfabaykal.crud.entity.User;
import com.alfabaykal.crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    private final UserService userService;

    public AppController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/allUsers")
    public String showAllUsers(Model model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "all-users-view";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute ("user") User user) {

        userService.saveUser(user);

        return "redirect:/allUsers";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam ("userId") int id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam ("userId") int id) {

        userService.deleteUser(id);

        return "redirect:/allUsers";
    }
}
