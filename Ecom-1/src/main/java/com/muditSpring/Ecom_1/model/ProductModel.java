package com.muditSpring.Ecom_1.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    String name;
    String brand;
    String description;
    String category;
    int price;


    String stockQuantity;
    boolean productAvailable;
    private Date releaseDate;


    String imageName;
    String imageType;

    @Lob
    byte[] imageData;

}
