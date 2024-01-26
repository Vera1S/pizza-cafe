package com.vera1s.pizzacafe.service.interfaces;

import com.vera1s.pizzacafe.entity.IngredientsName;

public interface IngredientsService {

    IngredientsName getNewIngredients(Integer id);
    IngredientsName getById(Integer id);
    void save(IngredientsName ingredientsName);
}
