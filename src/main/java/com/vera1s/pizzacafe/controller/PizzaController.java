package com.vera1s.pizzacafe.controller;

import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.service.interfaces.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping(value = "/pizza/{id}")
    public Pizza getPizzaById(@PathVariable(value = "id")Integer id){
        Pizza pizza = pizzaService.getById(id);
        return pizzaService.getById(id);
    }

}
