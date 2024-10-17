package org.example.springboot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.stereotype.Controller;

@Controller
@RequestMapping
public class DemoController {

    @GetMapping("/home")
    public String hello(){
        return "home";
    }



}
