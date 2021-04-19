package com.cookingapp.repositories;

import com.cookingapp.models.entities.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findAll();
}

