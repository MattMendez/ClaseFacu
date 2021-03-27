package com.example.demo.Controllers;

import com.example.demo.dto.CountriesName;
import com.example.demo.dto.UserWithEmails;
import com.example.demo.entitys.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService firstService;

    @GetMapping(path = "/algo")
    public ResponseEntity<User> findString(){

        return ResponseEntity.ok(User.builder()
                .nombre("Pimpon")
                .build());
    }

    @GetMapping(path = "/paises")
    public ResponseEntity<List<String>> findCountrys(){

        return ResponseEntity.ok(firstService.findCountrys());
    }

}
