package com.tommylean.SpringBootMvcHibernate.controller;

import com.tommylean.SpringBootMvcHibernate.models.User;
import com.tommylean.SpringBootMvcHibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public String showAllUsers(Model model){
        List<User> users = service.listUsers();
        model.addAttribute("users", users);
        return "allUsers";
    }

    @GetMapping("/new")
    public String showFormAddUser(Model model){
        model.addAttribute("user", new User());
        return "newUser";
    }


    @PostMapping
    public String addUser(@ModelAttribute("user") User user){
        service.add(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateUserForm(Model model, @RequestParam("id") Long id){
        model.addAttribute("user", service.findById(id));
        return "updateUser";
    }

    @PatchMapping("/update")
    public String updateUser(@ModelAttribute("user") User user){
        service.update(user);
        return "redirect:/users";
    }

    @DeleteMapping()
    public String deleteUser(@ModelAttribute("user") User user){
        service.delete(user);
        return "redirect:/users";
    }




}
