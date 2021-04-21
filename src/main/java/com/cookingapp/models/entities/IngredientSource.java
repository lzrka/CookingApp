package com.cookingapp.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(exclude = {"createdAt", "lastUpdatedAt"})
public class IngredientSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String icon;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    public IngredientSource(String name, String description, String icon) {
        this.name = name;
        this.description = description;
        this.icon = icon;
    }

    public IngredientSource() {

    }


//TODO : Relation
    //@ManyToOne(mapped by ="?")
    //List<StorageItem> storageItems;


    @PrePersist
    public void stampNewSourceCreation() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void stampModifiedDate() {
        lastUpdatedAt = LocalDateTime.now();
    }
}
