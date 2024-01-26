package com.vera1s.pizzacafe.controller;

import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.service.interfaces.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping(value = "/pizza/{id}")
    public Pizza getPizzaById(@PathVariable(value = "id")Integer id){
        Pizza pizza = pizzaService.getById(id);
        return pizza;
    }
    @PostMapping(value = "/pizza")
    public void savePizza(@RequestBody Pizza pizza){
        pizzaService.save(pizza);
    }
    @DeleteMapping(value = "/pizza/{id}")
    public void deleteById(@PathVariable(value = "id")Integer id){
        pizzaService.deleteById(id);
    }
    @PutMapping(value = "/pizza/{id}")
    public void updatePizzaById(@PathVariable(value = "id")Integer id, @RequestBody Pizza pizza){
        pizzaService.update(id, pizza);
    }
}
