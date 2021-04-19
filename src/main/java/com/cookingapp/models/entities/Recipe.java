package com.cookingapp.models.entities;


import com.cookingapp.models.Allergen;
import com.cookingapp.models.Difficulty;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String title;
    protected String imageUrl;
    protected Long preparationTime;
    protected Difficulty difficulty;
    // protected String ingredients; // TODO: refactor it later to one to many relation
    protected String preparation;

    @Setter
    @ManyToOne
    protected RecipeCategory category;
    // protected Set<Allergen> allergens = new HashSet<>();


    public Recipe(String title, String imageUrl, Long preparationTime, Difficulty difficulty, String ingredients, String preparation, Set<Allergen> allergens) {
        this();
        this.title = title;
        this.imageUrl = imageUrl;
        this.preparationTime = preparationTime;
        this.difficulty = difficulty;
        // this.ingredients = ingredients;
        this.preparation = preparation;
        //this.allergens = allergens;
    }
}