package com.example.demo.Controllers;

import com.example.demo.dto.UserWithEmails;
import com.example.demo.entitys.User;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    UserService firstService;

    @GetMapping
    public UserWithEmails findNumber(){
        return firstService.algo(1);
    }

    @PostMapping
    public String findString(){
        return "hbfuidsguf";
    }

}
