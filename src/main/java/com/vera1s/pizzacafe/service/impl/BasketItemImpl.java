package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.BasketItem;
import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.repository.BasketItemRepository;
import com.vera1s.pizzacafe.service.interfaces.BasketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Класс для создания карзины
 */

@Service
@RequiredArgsConstructor
public class BasketItemImpl implements BasketItemService {

    private final BasketItemRepository basketItemRepository;

    @Override
    @Transactional
    public BasketItem getById(Integer id) {
        Optional<BasketItem> optional = basketItemRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null; //return basketItemRepository.findById(id).orElse(null);
        }
    }

    @Override
    @Transactional
    public List<BasketItem> getAllBasketItem() {
        return basketItemRepository.findAll();
    }

    @Override
    @Transactional
    public Collection<BasketItem> getAllByCustomers(Customer customer) {
        return basketItemRepository.findAllByCustomers(customer);
    }


    @Override
    @Transactional
    public void save(BasketItem basketItem) {
        if (basketItem == null) {
            return;
        }
        basketItemRepository.save(basketItem);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (id != null && basketItemRepository.existsById(id)){
            basketItemRepository.deleteById(id);
        }
    }

    @Override
    @Transactional
    public void update(Integer id, BasketItem basketItem) {
        Optional<BasketItem> persistBasketItemOptional = basketItemRepository.findById(id);
        if (persistBasketItemOptional.isPresent()) { //если есть
            BasketItem persistBasketItem = persistBasketItemOptional.get();//покажи
            persistBasketItem.setNameDishes(basketItem.getNameDishes()); //в старый BasketItem устанавливаем новое имя
            persistBasketItem.setMenuItem(basketItem.getMenuItem());
            persistBasketItem.setSizeItem(basketItem.getSizeItem());
            persistBasketItem.setId(basketItem.getId());
            persistBasketItem.setOrder(basketItem.getOrder());
            persistBasketItem.setCustomers(basketItem.getCustomers());
            persistBasketItem.setPrice(basketItem.getPrice());
            persistBasketItem.setQuantity(basketItem.getQuantity());
            basketItemRepository.save(persistBasketItem); //пересохраняем старый BasketItem
        }
    }

}
