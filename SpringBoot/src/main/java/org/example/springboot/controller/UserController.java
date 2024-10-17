package org.example.springboot.controller;

import org.example.springboot.model.User;
import org.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    //@Autowired
   // private  UserService userService;

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }


    @PostMapping("/login")
    public String login(Model model ,User user){
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        if(userService.login(user.getEmail(), user.getPassword())){
            return "redirect:/home";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";

    }



    @PostMapping("/signin")
public String signin(Model model ,User user){
        userService.sample();
        System.out.println("from signin"+user.getEmail());
        System.out.println("from signin"+user.getPassword());
        if(userService.save(user)){
            return "redirect:/home";
        }
        model.addAttribute("error", "Email is already in use");
        return "signup";
    }


    @GetMapping("/signin")
    public String signin(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }




}
