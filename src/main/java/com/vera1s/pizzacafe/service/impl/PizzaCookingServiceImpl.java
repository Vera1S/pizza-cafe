package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Ingredients;
import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.repository.PizzaRepository;
import com.vera1s.pizzacafe.service.interfaces.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaCookingServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;


//    public List<Ingredients> getIngredientsForPizza(Integer pizzaId) { //убрать класс
//        Pizza pizza = getById(pizzaId); // Предполагается, что у вас есть метод getById в сервисе
//        if (pizza != null) {
//            return pizza.getIngredients();
//        } else {
//            throw new RuntimeException("Pizza not found");
//        }
//    }
       @Override
    public Pizza getNewPizza(Integer id) {
        return null;
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return null;
    }

    @Override
    public Pizza getById(Integer id) {
        return null;
    }

    @Override
    public void save(Pizza pizza) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Integer id, Pizza pizza) {

    }
}
