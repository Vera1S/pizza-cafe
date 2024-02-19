package com.vera1s.pizzacafe.service.interfaces;


import com.vera1s.pizzacafe.entity.Pizza;

import java.util.List;

public interface PizzaService {

    public List<Pizza> getAllPizzas();

    Pizza getById(Integer id);

    void save(Pizza pizza, Integer cafeId);

    void deleteById(Integer id);

    void update(Integer id, Pizza pizza);

}
