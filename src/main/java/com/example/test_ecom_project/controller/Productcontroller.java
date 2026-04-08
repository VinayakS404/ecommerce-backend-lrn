package com.example.test_ecom_project.controller;

import com.example.test_ecom_project.model.Products;
import com.example.test_ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Productcontroller {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Products> getAllProducts(){
        return service.getAllProductsData();
    }

    @GetMapping("/product/{id}")
    public Products getProductById(@PathVariable int id){
        return service.getProductById(id);
    }
}
