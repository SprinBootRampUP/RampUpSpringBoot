package org.example.springboot.controller;


import org.example.springboot.model.User;
import org.example.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;


    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }


    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user,Model model ){
        System.out.println("from signup"+user);
        if(loginService.register(user)){
            return "redirect:/home";
        }
        model.addAttribute("error", "No user");
        return "signup";
    }


//    @GetMapping("/login")
//    public String login(Model model){
//        model.addAttribute("user", new User());
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute("user") User user,Model model ){
//
//        if(loginService.login(user)){
//            return "redirect:/home";
//        }
//        model.addAttribute("error", "Invalid credentials");
//        return "login";
//    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
