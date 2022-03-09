package com.example.TravelGuide.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/") // To apply controller to Main page use just /
    public String home (Model model) {
        model.addAttribute("title", "Main page");
        return "login";
    }
//    @GetMapping("/login") // To apply controller to Main page use just /
//    public String login (Model model) {
//        model.addAttribute("title", "Login");
//        return "login";
//    }
//    @GetMapping("/register") // To apply controller to Main page use just /
//    public String register (Model model) {
//        model.addAttribute("title", "Register");
//        return "register";
//    }
    @GetMapping("/about") // To apply controller to Main page use just /
    public String about (Model model) {
        model.addAttribute("title", "About Us");
        return "about";
    }

}

