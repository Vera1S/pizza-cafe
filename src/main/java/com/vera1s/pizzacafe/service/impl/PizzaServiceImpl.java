package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.repository.PizzaRepository;
import com.vera1s.pizzacafe.service.PizzaCookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaCookingService {

    private final PizzaRepository pizzaRepository;

    @Override
    public Pizza getNewPizza(Integer id) {
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
