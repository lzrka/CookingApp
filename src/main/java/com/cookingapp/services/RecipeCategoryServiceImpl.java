package com.cookingapp.services;

import com.cookingapp.models.entities.RecipeCategory;
import com.cookingapp.repositories.RecipeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RecipeCategoryServiceImpl implements RecipeCategoryService {

    @Autowired
    RecipeCategoryRepository recipeCategoryRepository;

    @Override
    public RecipeCategory addCategory(RecipeCategory category) {
        Objects.requireNonNull(category);
        if (category.getId() != null) {
            throw new UnsupportedOperationException("Id of new entity should not been defined.");
        }
        return recipeCategoryRepository.save(category);
    }
}
