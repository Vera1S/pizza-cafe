package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.entity.MenuItem;
import com.vera1s.pizzacafe.service.interfaces.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menuItem")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @GetMapping(value = "/id")
    public MenuItem getPizzaById(@PathVariable(value = "id")Integer id){
        MenuItem menuItem = menuItemService.getById(id);
        return menuItem;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<MenuItem>> getAllMenuItem() {
        List<MenuItem> menuItems = menuItemService.getAllCafe();
        return ResponseEntity.ok(menuItems);
    }
    @PostMapping(value = "/save/{id}")
    public void saveMenuItem(@RequestBody MenuItem menuItem){
        menuItemService.save(menuItem);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id")Integer id){
        menuItemService.deleteById(id);
    }
    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable(value = "id")Integer id, @RequestBody MenuItem menuItem){
        menuItemService.update(id, menuItem);
    }
}
