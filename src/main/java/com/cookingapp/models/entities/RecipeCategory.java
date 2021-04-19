package com.cookingapp.models.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    protected String description;
    protected String icon;
    @OneToMany(mappedBy = "category")
    protected List<Recipe> recipes;

    public RecipeCategory(String name, String description, String icon) {
        this.name = name;
        this.description = description;
        this.icon = icon;
    }
}