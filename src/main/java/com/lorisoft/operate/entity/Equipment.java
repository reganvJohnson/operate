package com.lorisoft.operate.entity;

        import lombok.Data;

        import javax.persistence.*;
        import javax.validation.constraints.Min;
        import javax.validation.constraints.NotBlank;

@Entity // This tells Hibernate to make a table out of this class
@Data // Lombok: adds getters and setters
public class Equipment {

    public Equipment(CarClass car_class, Integer era, String description, String short_description, String aar_code, Integer length, String notes) {
        this.car_class = car_class;
        this.era = era;
        this.description = description;
        this.short_description = short_description;
        this.aar_code = aar_code;
        this.length = length;
        this.notes = notes;
    }

    public Equipment() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "CLASS_ID", nullable = false)
    private CarClass car_class;
    private Integer era;
    @NotBlank(message = "Car description is mandatory")
    private String description;
    @NotBlank(message = "short Car description is mandatory")
    private String short_description;
    private String aar_code;
    @Min(value=1, message="Cars must have a length")
    private Integer length;
    private String notes;
}
