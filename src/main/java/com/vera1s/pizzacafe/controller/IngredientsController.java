package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.entity.Ingredients;
import com.vera1s.pizzacafe.service.interfaces.IngredientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ingredients")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @GetMapping(value = "/id")
    public Ingredients getIngredientsById(@PathVariable(value = "id")Integer id){
        Ingredients ingredients = ingredientsService.getById(id);
        return ingredients;
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Ingredients>>getAllIngredients(){
        List<Ingredients> ingredients = ingredientsService.getAllIngredients();
        return ResponseEntity.ok(ingredients);
    }

    @PostMapping(value = "/save/{id}")
    public void saveIngredients(@RequestBody Ingredients ingredients){
        ingredientsService.save(ingredients);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id")Integer id){
        ingredientsService.deleteById(id);
    }
    @PutMapping(value = "/update/{id}")
    public void updateIngredientsById(@PathVariable(value = "id")Integer id, @RequestBody Ingredients ingredients){
        ingredientsService.update(id, ingredients);
    }

}
