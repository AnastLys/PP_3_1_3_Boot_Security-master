package ru.kata.springboot_securitydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.springboot_securitydemo.model.User;
import ru.kata.springboot_securitydemo.service.RoleService;
import ru.kata.springboot_securitydemo.service.UserServiceImp;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public String userList(Model model) {
        model.addAttribute("users", userServiceImp.listUsers());
        return "userList";
    }

    @GetMapping("/addUser")
    public String newUser(ModelMap model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String create(@ModelAttribute("newUser") User user) {
        userServiceImp.addUser(user);
        return "redirect:/admin/";
    }

    @GetMapping("/show")
    public String showUser(ModelMap model, @RequestParam("id") long id) {
        model.addAttribute("theUser", userServiceImp.findUser(id));
        return "showUser";
    }

    @GetMapping("/edit")
    public String showUserEditPage(ModelMap model, @RequestParam("id") long id) {
        model.addAttribute("theUser", userServiceImp.findUser(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "editUser";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("theUser") User user) {
        userServiceImp.updeteUser(user);
        return "redirect:/admin/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") long id) {
        userServiceImp.deleteUser(id);
        return "redirect:/admin/";
    }
}
