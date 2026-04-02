package com.example.test_ecom_project.service;

import com.example.test_ecom_project.model.Products;
import com.example.test_ecom_project.repo.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductsRepo repo;

    public List<Products> getAllProductsData() {
        return  repo.findAll();
    }
}
