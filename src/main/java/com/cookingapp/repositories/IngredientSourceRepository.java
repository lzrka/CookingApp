package com.cookingapp.repositories;

import com.cookingapp.models.entities.IngredientSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientSourceRepository extends CrudRepository<IngredientSource, Long> {

}