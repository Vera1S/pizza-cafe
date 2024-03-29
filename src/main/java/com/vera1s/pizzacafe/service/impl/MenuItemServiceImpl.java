package com.vera1s.pizzacafe.service.impl;


import com.vera1s.pizzacafe.entity.MenuItem;
import com.vera1s.pizzacafe.repository.MenuItemRepository;
import com.vera1s.pizzacafe.service.interfaces.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Override
    @Transactional
    public MenuItem getById(Integer id) {
        Optional<MenuItem> optional = menuItemRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null; //return menuItemRepository.findById(id).orElse(null);
        }
    }

    @Override
    @Transactional
    public List<MenuItem> getAllMenuItem() {
        return menuItemRepository.findAll();
    }

    @Override
    @Transactional
    public void save(MenuItem menuItem) {
        if (menuItem == null){
            return;
        }
        menuItemRepository.save(menuItem);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (id != null && menuItemRepository.existsById(id)){
            menuItemRepository.deleteById(id);
        }
    }

    @Override
    @Transactional
    public void update(Integer id, MenuItem menuItem) {
        Optional<MenuItem> persistMenuItemOptional = menuItemRepository.findById(id);
        if (persistMenuItemOptional.isPresent()) { //если есть
            MenuItem persistMenuItem = persistMenuItemOptional.get();//покажи
            persistMenuItem.setNamePizza(menuItem.getNamePizza()); //в старое menuItem устанавливаем новое имя
            menuItemRepository.save(persistMenuItem); //пересохраняем старое menuItem
        }
    }
}
