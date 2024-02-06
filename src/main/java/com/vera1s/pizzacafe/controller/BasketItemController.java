package com.vera1s.pizzacafe.controller;

import com.vera1s.pizzacafe.entity.BasketItem;

import com.vera1s.pizzacafe.service.interfaces.BasketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basketItem")
public class BasketItemController {

    private final BasketItemService basketItemService;

    @GetMapping(value = "/id")
    public BasketItem getById(@PathVariable(value = "id")Integer id){
        BasketItem basketItems = basketItemService.getById(id);
        return basketItems;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<BasketItem>> getAllBasket() {
        List<BasketItem> basket = basketItemService.getAllBasketItem();
        return ResponseEntity.ok(basket);
    }
    @PostMapping(value = "/save")
    public void saveBasket(@RequestBody BasketItem basketItem){
        basketItemService.save(basketItem);
    }
    @DeleteMapping(value = "/delete")
    public void deleteById(@PathVariable(value = "id")Integer id){
        basketItemService.deleteById(id);
    }

    @PutMapping(value = "/update")
    public void updateBasketById(@PathVariable(value = "id")Integer id, @RequestBody BasketItem basketItem){
        basketItemService.update(id, basketItem);
    }
}
