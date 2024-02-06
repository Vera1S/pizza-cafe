package com.vera1s.pizzacafe.service.interfaces;

import com.vera1s.pizzacafe.entity.BasketItem;

import java.util.List;

public interface BasketItemService {

    BasketItem getById (Integer id);
    List<BasketItem> getAllBasketItem();
    void save(BasketItem basketItem);
    void deleteById(Integer id);

    void update(Integer id, BasketItem basketItem);
}
