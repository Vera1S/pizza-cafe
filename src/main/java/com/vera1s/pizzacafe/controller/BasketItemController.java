package com.vera1s.pizzacafe.controller;

import com.vera1s.pizzacafe.dto.BasketItemDTO;
import com.vera1s.pizzacafe.entity.BasketItem;

import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.service.interfaces.BasketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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
    @PostMapping(value = "/all-items-by-customers")
    public ResponseEntity<Collection<BasketItemDTO>> getByCustomers(@RequestBody Customer customer){
        Collection<BasketItem> basket = basketItemService.getAllByCustomers(customer);
        Collection<BasketItemDTO> basketItemDTOS = basket.stream()
                .map(i -> new BasketItemDTO(i.getId(), i.getNameDishes(), i.getQuantity(), i.getSizeItem(), i.getPrice()))
                .toList();
        return ResponseEntity.ok(basketItemDTOS);
    }
    @PostMapping(value = "/save")
    public void saveBasket(@RequestBody BasketItem basketItem){
        basketItemService.save(basketItem);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id")Integer id){
        basketItemService.deleteById(id);
    }

    @PutMapping(value = "/update/{id}")
    public void updateBasketById(@PathVariable(value = "id")Integer id, @RequestBody BasketItem basketItem){
        basketItemService.update(id, basketItem);
    }
}
