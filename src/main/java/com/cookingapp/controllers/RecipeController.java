package com.cookingapp.controllers;

import com.cookingapp.models.entities.Recipe;
import com.cookingapp.models.entities.RecipeCategory;
import com.cookingapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class RecipeController {

    @Autowired
    RecipeService recipeService;


    @GetMapping("/recipe/list")
    public String listRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "index";
    }

    @GetMapping("/recipe/add")
    public String addRecipeForm() {
        return "addrecipe";
    }
    @PostMapping("/recipe/add")
    public String addRecipe(@ModelAttribute Recipe recipe) throws IOException {
      //  RecipeCategory soup = new RecipeCategory("Leves", null, null);
       // soup = categoryService.addCategory(soup);
       // recipe.setCategory(soup);
        recipeService.addRecipe(recipe);
        return "addrecipe";
    }

}