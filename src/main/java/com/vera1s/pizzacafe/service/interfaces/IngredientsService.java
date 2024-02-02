package com.vera1s.pizzacafe.service.interfaces;

import com.vera1s.pizzacafe.entity.Ingredients;

import java.util.List;

public interface IngredientsService {

    Ingredients getById(Integer id);

    List<Ingredients> getAllIngredients();

    void save(Ingredients ingredients);

    void remove(Ingredients ingredients);
}
