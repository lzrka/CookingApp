package com.cookingapp.services;


import com.cookingapp.models.entities.Recipe;
import com.cookingapp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


    @Lazy
    @Service
    public class RecipeServiceImplementation implements RecipeService {

        @Autowired
        RecipeRepository recipeRepository;

        @Override
        public List<Recipe> getAllRecipes() {
            return recipeRepository.findAll();
        }

        @Override
        public Recipe addRecipe(Recipe recipe) {
            Objects.requireNonNull(recipe);
            if (recipe.getId() != null) {
                throw new UnsupportedOperationException("Id of new entity should not been defined.");
            }
            return recipeRepository.save(recipe);
        }

        @Override
        public Recipe updateRecipe(Recipe recipe) {
            Objects.requireNonNull(recipe);
            if (recipe.getId() == null) {
                throw new UnsupportedOperationException("Id of an existing entity should been defined.");
            }

            if (!recipeRepository.existsById(recipe.getId())) {
                throw new UnsupportedOperationException(
                        "Please use addRecipe feature for creation a new entity.");
            }
            return recipeRepository.save(recipe);
        }

        @Override
        public void removeRecipe(Recipe recipe) {
            Objects.requireNonNull(recipe);
            if (recipe.getId() == null) {
                throw new UnsupportedOperationException("Id of an existing entity should been defined.");
            }

            recipeRepository.delete(recipe);
        }

        @Override
        public void removeRecipe(Long recipeId) {
            Objects.requireNonNull(recipeId);
            recipeRepository.deleteById(recipeId);
        }
    }

