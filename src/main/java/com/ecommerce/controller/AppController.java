package com.ecommerce.controller;

import com.ecommerce.model.User;
import com.ecommerce.repository.UsersRepository;
import com.ecommerce.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AppController {
    @Autowired
    private IUserService iUserService;
    @GetMapping(" /")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public  String showSignUpForm(Model model){
        model.addAttribute("invalid", null);
        model.addAttribute("user",new User());

        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("user") User user, Model model){
        Optional<User> user1 = iUserService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if(user1.isPresent()){
            model.addAttribute("invalid", "User has already been registered");
            return "register";

        }
        if (!user1.isPresent()){
            model.addAttribute("user", "signup successful");
        }
        iUserService.saveUser(user);
        return "login";

    }
}
