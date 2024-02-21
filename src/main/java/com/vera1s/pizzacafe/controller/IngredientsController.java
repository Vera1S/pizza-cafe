package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.dto.IngredientsDTO;
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
    public IngredientsDTO getIngredientsById(@PathVariable(value = "id")Integer id){
        Ingredients ingredients = ingredientsService.getById(id);
        IngredientsDTO ingredientsDTO = new IngredientsDTO(ingredients.getId(), ingredients.getName());
        return ingredientsDTO;
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<IngredientsDTO>>getAllIngredients(){
        List<Ingredients> ingredients = ingredientsService.getAllIngredients();
        List<IngredientsDTO> ingredientsDTOS = ingredients.stream()
                .map(i -> new IngredientsDTO(i.getId(), i.getName()))
                .toList();
        return ResponseEntity.ok(ingredientsDTOS);
    }

    @PostMapping(value = "/save")
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
