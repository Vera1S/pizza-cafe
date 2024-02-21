package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.dto.MenuItemDTO;
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
    public MenuItemDTO getMenuItemById(@PathVariable(value = "id")Integer id){
        MenuItem menuItem = menuItemService.getById(id);
        MenuItemDTO menuItemDTO = new MenuItemDTO(menuItem.getId(), menuItem.getNamePizza(), menuItem.getSizeItem(),
                menuItem.getPrice());
        return menuItemDTO;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<MenuItemDTO>> getAllMenuItem() {
        List<MenuItem> menuItems = menuItemService.getAllMenuItem();
        List<MenuItemDTO> menuItemDTOS = menuItems.stream()
                .map(m -> new MenuItemDTO(m.getId(), m.getNamePizza(), m.getSizeItem(), m.getPrice()))
                .toList();
        return ResponseEntity.ok(menuItemDTOS);
    }
    @PostMapping(value = "/save")
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
