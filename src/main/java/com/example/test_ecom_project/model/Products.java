package com.example.test_ecom_project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String desc;
    private String  brand;
    private BigDecimal price;
    private String  category;

    private Date releaseDate;
    private Boolean available;
    private Integer stockQuantity = 0;

    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public String getImageType() {
        return imageType;
    }
}
