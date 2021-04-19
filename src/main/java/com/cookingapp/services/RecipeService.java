package com.cookingapp.services;

import com.cookingapp.models.entities.Recipe;

import java.io.IOException;
import java.util.List;

public interface RecipeService {

    List<Recipe> getAllRecipes();

    Recipe addRecipe(Recipe recipe) throws IOException;

    Recipe updateRecipe(Recipe recipe) throws IOException;

    void removeRecipe(Recipe recipe) throws IOException;

    void removeRecipe(Long recipeId) throws IOException;
}