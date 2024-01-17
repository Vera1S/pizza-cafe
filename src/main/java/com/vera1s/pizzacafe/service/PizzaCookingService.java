package com.vera1s.pizzacafe.service;

import com.vera1s.pizzacafe.entity.Pizza;

public interface PizzaCookingService {

    Pizza getNewPizza(Integer id);

    Pizza getById(Integer id);

    void save(Pizza pizza);

    void deleteById(Integer id);

    void update(Integer id, Pizza pizza);
}
