//package org.example.springboot.controller;
//
//import org.example.springboot.model.User;
//import org.example.springboot.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//import java.util.Optional;
//
//@Controller
//@Validated
//public class UserController {
//
//    //@Autowired
//   // private  UserService userService;
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    @GetMapping("/login")
//    public String login(Model model){
//        model.addAttribute("user", new User());
//        return "login";
//    }
//
//
//    @PostMapping("/login")
//    public String login(@Valid User user, Model model, BindingResult bindingResult){
//
//        if(bindingResult.hasErrors()){
//            System.out.println("qqqqq");
//        }
//
//        System.out.println(user.getEmail());
//        System.out.println(user.getPassword());
//
//       Optional<User> currentUser= userService.login(user.getEmail(), user.getPassword());
//
//        return  currentUser.map(
//               (user1) -> "redirect:/home"
//               )
//               .orElseGet(
//                       () ->{
//           model.addAttribute("error", "Invalid username or password");
//           return "login";
//       });
//
////
////       if(currentUser.isPresent()){
////           return "redirect:/home";
////       }
//
////        if(userService.login(user.getEmail(), user.getPassword())){
////            return "redirect:/home";
////        }
////        model.addAttribute("error", "Invalid username or password");
////        return "login";
//
//    }
//
//
//
//
//
//    @GetMapping("/signup")
//    public String signup(Model model){
//        model.addAttribute("user", new User());
//        return "signup";
//    }
//
//
//
////    @PostMapping("/signup")
////    public String signup(@Valid @ModelAttribute("user") User user , BindingResult bindingResult){
////        System.out.println("from signup"+user.getEmail());
////        System.out.println("from signup"+user.getPassword());
////        System.out.println("from signup"+user);
////
////        if(bindingResult.hasErrors()){
////
////            System.out.println("has error");
////            return "signup";
////        }
////        System.out.println("NO error");
////
////       // model.addAttribute("error", "No user");
////        return "redirect:/home";
////
////    }
//
//    @PostMapping("/signup")
//    public String signup(@Valid @ModelAttribute("user") User user , BindingResult bindingResult){
//        System.out.println("from signup"+user.getEmail());
//        System.out.println("from signup"+user.getPassword());
//        System.out.println("from signup"+user);
//
//
//        userService.save(user);
//
//
//        if(bindingResult.hasErrors()){
//
//            System.out.println("has error");
//            return "signup";
//        }
//        System.out.println("NO error");
//
//         model.addAttribute("error", "No user ");
//        return "redirect:/home";
//
//    }
//
//
//
//
//
//
//}
