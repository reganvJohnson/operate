package com.lorisoft.operate.entity;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity // This tells Hibernate to make a table out of this class
@Data // Lombok: adds getters and setters
@AllArgsConstructor
@NoArgsConstructor
public class Module {

//    public Module(String full_name, String short_name, String owner, String size, String passing_siding, String description, String remarks) {
//       this.full_name = full_name;
//        this.short_name = short_name;
//        this.owner = owner;
//        this.size = size;
//        this.passing_siding = passing_siding;
//        this.description = description;
//        this.remarks = remarks;
//    }

//    public Module() {
//    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String full_name;
    @NotBlank(message = "Full module name is mandatory")
    private String short_name;
    private String owner;
    private String size;
    private String passing_siding;
    private String description;
    private String notes;
}
