package com.vera1s.pizzacafe.controller;

import com.vera1s.pizzacafe.dto.PizzaDTO;
import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.service.interfaces.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping(value = "/id")
    public Pizza getPizzaById(@PathVariable(value = "id")Integer id){
        Pizza pizza = pizzaService.getById(id);
        return pizza;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Pizza>> getAllPizzas() {
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        return ResponseEntity.ok(pizzas);
    }
    @PostMapping(value = "/save/{cafeId}")
    public void savePizza(@RequestBody Pizza pizza, @PathVariable(value = "cafeId")Integer cafeId){
        pizzaService.save(pizza, cafeId);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id")Integer id){
        pizzaService.deleteById(id);
    }
    @PutMapping(value = "/update/{id}")
    public void updatePizzaById(@PathVariable(value = "id")Integer id, @RequestBody Pizza pizza){
        pizzaService.update(id, pizza);
    }


}
