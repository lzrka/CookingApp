package com.cookingapp.repositories;

import com.cookingapp.models.entities.RecipeCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Long> {
}