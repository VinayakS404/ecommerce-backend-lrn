package com.example.test_ecom_project.service;

import com.example.test_ecom_project.model.Products;
import com.example.test_ecom_project.repo.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductsRepo repo;

    public List<Products> getAllProductsData() {
        return  repo.findAll();
    }

    public Products getProductById(int id) {
        return repo.findById(id).orElse(new Products());
    }

    public Products addProduct(Products product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }


    public Products updateProduct(int id, Products product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}
