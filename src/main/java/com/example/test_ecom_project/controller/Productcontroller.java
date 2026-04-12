package com.example.test_ecom_project.controller;

import com.example.test_ecom_project.model.Products;
import com.example.test_ecom_project.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Productcontroller {

    private static final Logger log = LoggerFactory.getLogger(Productcontroller.class);
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProductsData(),
                HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable int id ){
        Products product =  service.getProductById(id);
        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Products product,
                                        @RequestPart MultipartFile imageFile){
        try{
            Products product1 = service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        Products product = service.getProductById(productId);
        byte[] imageFile = product.getImageData();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct ( @PathVariable int id,
                                                  @RequestPart Products product,
                                                  @RequestPart MultipartFile imageFile){
        try{
            Products product1 = service.updateProduct(id,product,imageFile);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        if(product != null)
            return new ResponseEntity<>("updated",HttpStatus.OK);
        else
            return new ResponseEntity<>("failed to update",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Products product = service.getProductById(id);
        if(product != null){
            service.deleteProduct(id);
            return new ResponseEntity<>("deleted",HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("product not found",HttpStatus.NOT_FOUND);
    }
}
