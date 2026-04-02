package com.example.test_ecom_project.controller;

import com.example.test_ecom_project.model.Products;
import com.example.test_ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class Productcontroller {

    @Autowired
    ProductService service;

    @GetMapping("/")
    public String greet(){
        return ("hi");
    }
    @GetMapping("/products")
    public List<Products> getAllProducts(){
        return service.getAllProductsData();
    }
}
