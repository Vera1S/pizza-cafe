package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.IngredientsName;
import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.repository.IngredientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl {

    private final IngredientsRepository ingredientsRepository;

    public void addIngredientToPizza(Pizza pizza, IngredientsName ingredient) {
        pizza.getIngredients().add(ingredient);
    }

    // Метод для удаления ингредиента из пиццы
    public void removeIngredientFromPizza(Pizza pizza, IngredientsForPizza ingredient) {
        pizza.getIngredients().remove(ingredient);
    }
}
