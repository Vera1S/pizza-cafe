package com.vera1s.pizzacafe.service.interfaces;

import com.vera1s.pizzacafe.entity.BasketItem;
import com.vera1s.pizzacafe.entity.Customer;


import java.util.Collection;
import java.util.List;

public interface BasketItemService {

    BasketItem getById (Integer id);
    List<BasketItem> getAllBasketItem();
    Collection<BasketItem> getAllByCustomers(Customer customer);
    void save(BasketItem basketItem);
    void deleteById(Integer id);

    void update(Integer id, BasketItem basketItem);
}
