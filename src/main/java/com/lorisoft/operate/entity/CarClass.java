package com.lorisoft.operate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity // This tells Hibernate to make a table out of this class
@Data // Lombok: adds getters and setters
public class CarClass {

    public CarClass(String classification) {
        this.classification = classification;
    }

    public CarClass() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Car classification")
    private String classification;
}
