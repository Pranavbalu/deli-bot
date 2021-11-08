package com.delibot.controller;

import com.delibot.domain.DeliveryExecutive;
import com.delibot.domain.User;
import com.delibot.service.DeliveryExecutiveService;
import com.delibot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DeliveryExecutiveService deliveryExecutiveService;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user = userService.saveUser(user);

        if ( user.getUserType().equals(User.UserType.DELIVERY_EXECUTIVE)) {
            DeliveryExecutive deliveryExecutive = new DeliveryExecutive();
            deliveryExecutive.setFree(true);
            deliveryExecutive.setUserId(user.getId());
            deliveryExecutiveService.saveDeliveryExecutive(deliveryExecutive);
        }
        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = (List<User>) userService.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @PostMapping("/error")
    public String error(Model model) {
        return "error";
    }

}
