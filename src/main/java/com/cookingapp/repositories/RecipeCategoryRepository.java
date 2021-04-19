package com.cookingapp.repositories;

import com.cookingapp.models.entities.RecipeCategory;
import org.springframework.data.repository.CrudRepository;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Long> {
}