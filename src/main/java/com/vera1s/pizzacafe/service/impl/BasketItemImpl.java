package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.BasketItem;
import com.vera1s.pizzacafe.repository.BasketItemRepository;
import com.vera1s.pizzacafe.service.interfaces.BasketItemService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Класс для создания заказа - карзина
 */

@Service
@RequiredArgsConstructor
public class BasketItemImpl implements BasketItemService {

    private final BasketItemRepository basketItemRepository;

    @Override
    public BasketItem getById(Integer id) {
        Optional<BasketItem> optional = basketItemRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null; //return basketItemRepository.findById(id).orElse(null);
        }
    }

    @Override
    public List<BasketItem> getAllBasketItem() {
        return basketItemRepository.findAll();
    }


    @Override
    public void save(BasketItem basketItem) {
        if (basketItem == null) {
            return;
        }
        basketItemRepository.save(basketItem);
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null && basketItemRepository.existsById(id)){
            basketItemRepository.deleteById(id);
        }
    }

    @Override
    public void update(Integer id, BasketItem basketItem) {
        Optional<BasketItem> persistBasketItemOptional = basketItemRepository.findById(id);
        if (persistBasketItemOptional.isPresent()) { //если есть
            BasketItem persistBasketItem = persistBasketItemOptional.get();//покажи
            persistBasketItem.setNameDishes(basketItem.getNameDishes()); //в старый BasketItem устанавливаем новое имя
            //заменить всю карзину
            basketItemRepository.save(persistBasketItem); //пересохраняем старый BasketItem
        }
    }

}
