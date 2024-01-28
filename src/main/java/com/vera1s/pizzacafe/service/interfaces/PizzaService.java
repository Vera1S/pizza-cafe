package com.vera1s.pizzacafe.service.interfaces;


import com.vera1s.pizzacafe.entity.Pizza;

import java.util.List;

public interface PizzaService {

    Pizza getNewPizza(Integer id);

    Pizza getById(Integer id);

    void save(Pizza pizza);

    void deleteById(Integer id);

    void update(Integer id, Pizza pizza);

}
