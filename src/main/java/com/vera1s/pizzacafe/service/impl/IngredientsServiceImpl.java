package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Ingredients;
import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.repository.IngredientsRepository;
import com.vera1s.pizzacafe.service.interfaces.IngredientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientsRepository ingredientsRepository;

    @Override
    public Ingredients getNewIngredients(Integer id) {
        List<Ingredients> ingredients = ingredientsRepository.findAll();
        if (ingredients.isEmpty()){
            throw new RuntimeException("Unable to create new ingredient - no existing ingredients found.");
        }
        return new Ingredients();
    }


    @Override
    public Ingredients getById(Integer id) {
        Optional<Ingredients> optional = ingredientsRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null; //return ingredientsRepository.findById(id).orElse(null);
        }
    }

    @Override
    public void save(Ingredients ingredients) {
        if (ingredients == null){
            return;
        }
        ingredientsRepository.save(ingredients);
    }

    @Override
    public void add(Ingredients ingredients) {
           }

    @Override
    public void remove(Ingredients ingredients) {

    }

//    public void addIngredientToPizza(Pizza pizza, Ingredients ingredient) {
//        List<Pizza> ingredientToPizza = new ArrayList<>();
//        pizza.getIngredients().add(ingredient);
//    }
//
//        public void removeIngredientFromPizza(Pizza pizza, IngredientsForPizza ingredient) {
//        pizza.getIngredients().remove(ingredient);
    }

