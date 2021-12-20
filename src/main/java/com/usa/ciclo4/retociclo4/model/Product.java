package com.usa.ciclo4.retociclo4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String reference;
    private String brand;
    private String category;
    //private String presentation;
    private String description;
    private boolean availability;
    private Double price;
    private Integer quantity;
    private String photography;
}
