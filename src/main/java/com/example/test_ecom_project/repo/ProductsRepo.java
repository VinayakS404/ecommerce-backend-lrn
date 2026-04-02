package com.example.test_ecom_project.repo;

import com.example.test_ecom_project.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepo extends JpaRepository<Products, Integer> {
}
