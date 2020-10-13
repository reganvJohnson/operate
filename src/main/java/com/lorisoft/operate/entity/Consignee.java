package com.lorisoft.operate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity // This tells Hibernate to make a table out of this class
@Data // Lombok: adds getters and setters
@AllArgsConstructor
@NoArgsConstructor
public class Consignee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private Integer module_id;

    @NotBlank(message = "Full module name is mandatory")
    private String name;
    }
