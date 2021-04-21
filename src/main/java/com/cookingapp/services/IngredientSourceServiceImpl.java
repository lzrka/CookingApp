package com.cookingapp.services;

import com.cookingapp.exceptions.types.BadRequestException;
import com.cookingapp.models.entities.IngredientSource;
import com.cookingapp.repositories.IngredientSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class IngredientSourceServiceImpl implements IngredientSourceService {

    private IngredientSourceRepository repository;

    @Autowired
    public void setRepository(IngredientSourceRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {

       IngredientSource ingredientSource = new IngredientSource("salt", "makes food salty", "https://www.self.com/story/common-types-of-cooking-salt-when-to-use");
        repository.save(ingredientSource);

    }

    @Override
    public Iterable<IngredientSource> listAllIngredientSource() {
        return repository.findAll();
    }

    @Override
    public IngredientSource addASource(IngredientSource source) {
        nullCheck(source, "New source is not defined.");
        if (source.getId() != null) {
            throw new BadRequestException("Id must not be present!");
        }
        return repository.save(source);
    }

    @Override
    public IngredientSource deleteIngredientSource(Long id) {
        nullCheck(id, "Id is not defined.");
        IngredientSource ingredientSource = findIngredientSource(id);
        repository.delete(ingredientSource);
        return ingredientSource;
    }

    public IngredientSource findSourceById(Long id) {
        nullCheck(id, "Id is not defined.");
        return findIngredientSource(id);
    }

    public IngredientSource update(Long id, IngredientSource modifiedSource) {
        nullCheck(id, "Id is not defined.");
        nullCheck(modifiedSource, "Nothing to modify.");

        IngredientSource sourceToUpdate = findIngredientSource(id);
        String newName = modifiedSource.getName();
        String newDescription = modifiedSource.getDescription();
        String newIcon = modifiedSource.getIcon();

        //Id has to be present is request body, and needs to be equal to the path variable id,
        if (!id.equals(modifiedSource.getId())) {
            throw new BadRequestException("Id's not match");
        }

        boolean updated = false;
        if (newName != null && !sourceToUpdate.getName().equals(newName)
        ) {
            sourceToUpdate.setName(newName);
            updated = true;
        }
        if (newDescription != null && !sourceToUpdate.getDescription().equals(newDescription)
        ) {
            sourceToUpdate.setDescription(newDescription);
            updated = true;
        }
        if (newIcon != null && !sourceToUpdate.getIcon().equals(newIcon)
        ) {
            sourceToUpdate.setIcon(newIcon);
            updated = true;
        }

        if (updated) {
            return repository.save(sourceToUpdate);
        }
        return sourceToUpdate;
    }

    private IngredientSource findIngredientSource(Long id) {
        Optional<IngredientSource> sourceById = repository.findById(id);
        return sourceById.orElseThrow(
                () -> new EntityNotFoundException(
                        "Ingredient Source with id : " + id + " was not found."));
    }

    private <T> void nullCheck(T o, String message) {
        if (o == null) {
            throw new BadRequestException(message);
        }
    }
}