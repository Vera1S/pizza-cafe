package com.vera1s.pizzacafe.service.interfaces;

import com.vera1s.pizzacafe.entity.Ingredients;

public interface IngredientsService {

    Ingredients getNewIngredients(Integer id);
    Ingredients getById(Integer id);
    void save(Ingredients ingredients);

    void add(Ingredients ingredients);
    void remove(Ingredients ingredients);
}
