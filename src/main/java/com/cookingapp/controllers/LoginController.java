package com.cookingapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


        @RequestMapping("/login")
        public String login(@RequestParam(required = false) Boolean error,
                            @RequestParam(required = false) Boolean logout) {
            System.out.println("login error: " + error + ", logout: " + logout);
            return "login";
        }

        @RequestMapping("/home")
        public String home() {
            return "index";
        }


}
