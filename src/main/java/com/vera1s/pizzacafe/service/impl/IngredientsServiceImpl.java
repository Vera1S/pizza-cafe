package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.IngredientsName;
import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.repository.IngredientsRepository;
import com.vera1s.pizzacafe.service.interfaces.IngredientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientsRepository ingredientsRepository;

    @Override
    public IngredientsName getNewIngredients(Integer id) {
        return null;
    }

    @Override
    public IngredientsName getById(Integer id) {
        return null;
    }

    @Override
    public void save(IngredientsName ingredientsName) {
    }

    public void addIngredientToPizza(Pizza pizza, IngredientsName ingredient) {
        List<Pizza> ingredientToPizza = new ArrayList<>();
        pizza.getIngredients().add(ingredient);
    }

        public void removeIngredientFromPizza(Pizza pizza, IngredientsForPizza ingredient) {
        pizza.getIngredients().remove(ingredient);
    }
}
