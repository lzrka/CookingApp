package com.cookingapp.controllers;

import com.cookingapp.models.entities.IngredientSource;
import com.cookingapp.services.IngredientSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class IngredientSourceRestController {

    private IngredientSourceService service;

    @Autowired
    public void setService(IngredientSourceService service) {
        this.service = service;
    }

    @GetMapping("/ingredient-source")
    public ResponseEntity<Iterable<IngredientSource>> listSources() {
        return ResponseEntity.ok(service.listAllIngredientSource());
    }

    @GetMapping("/ingredient-source/{id}")
    public ResponseEntity<IngredientSource> findSourceById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findSourceById(id));
    }

    @PostMapping("/ingredient-source")
    public ResponseEntity<IngredientSource> addNewSource(@RequestBody IngredientSource source) {
        return ResponseEntity.ok(service.addASource(source));
    }

    @PutMapping("/ingredient-source/{id}")
    public ResponseEntity<IngredientSource> updateSource(@PathVariable Long id,
                                                         @RequestBody IngredientSource source) {
        return ResponseEntity.ok(service.update(id, source));
    }

    @DeleteMapping("/ingredient-source/{id}")
    public ResponseEntity<IngredientSource> deleteSourceById(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteIngredientSource(id));
    }
}
