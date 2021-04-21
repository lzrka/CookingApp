package com.cookingapp.services;


import com.cookingapp.models.entities.IngredientSource;

public interface IngredientSourceService {

        Iterable<IngredientSource> listAllIngredientSource();

        IngredientSource addASource(IngredientSource source);

        IngredientSource findSourceById(Long id);

        IngredientSource update(Long id, IngredientSource source);

        IngredientSource deleteIngredientSource(Long id);

}
