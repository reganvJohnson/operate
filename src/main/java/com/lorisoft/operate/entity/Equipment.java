package com.lorisoft.operate.entity;

        import lombok.Data;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Data // Lombok: adds getters and setters
public class Equipment {

    public Equipment(String car_class, String description, String short_description, Integer length, String notes) {
        this.car_class = car_class;
        this.description = description;
        this.short_description = short_description;
        this.length = length;
        this.notes = notes;
    }

    public Equipment() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String car_class;

    private String description;

    private String short_description;

    private Integer length;

    private String notes;
}
