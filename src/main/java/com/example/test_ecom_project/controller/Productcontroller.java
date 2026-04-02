package com.example.test_ecom_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class Productcontroller {
    @GetMapping("/")
    public String greet(){
        return ("hi");
    }
}
