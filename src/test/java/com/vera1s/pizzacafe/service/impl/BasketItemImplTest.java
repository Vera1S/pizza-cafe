package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.BasketItem;
import com.vera1s.pizzacafe.entity.MenuItem;
import com.vera1s.pizzacafe.entity.Order;
import com.vera1s.pizzacafe.entity.enums.SizeItem;
import com.vera1s.pizzacafe.repository.BasketItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BasketItemImplTest {

    @Mock
    private BasketItemRepository basketItemRepository;

    @InjectMocks
    private BasketItemImpl basketItemImpl;
    //private Collection<BasketItem> basketItem;
    private List<BasketItem> basketItems;

    @BeforeEach
    void setUp() {
        // Создаем список пицц
        basketItems = new ArrayList<>();

        // Добавляем несколько экземпляров пицц в список
        basketItems.add(new BasketItem(1, "apple", 2,
                SizeItem.MEDIUM, 6.0, null, new Order(), new MenuItem()));
        basketItems.add(new BasketItem(2, "orenge", 1,
                SizeItem.MEDIUM, 4.0, null, new Order(), new MenuItem()));
    }
    @Test
    public void getAllBasketItem(){

        // Задаем поведение мокито для метода findAll()
        when(basketItemRepository.findAll()).thenReturn(basketItems);

        // Запускаем тестируемый метод
        List<BasketItem> returnBasketItem = basketItemImpl.getAllBasketItem();

        // Проверяем результаты теста
        assertNotNull(returnBasketItem);
        assertEquals(2, returnBasketItem.size());

        BasketItem returnBasketItemElement = returnBasketItem.get(0);
        assertEquals("apple", returnBasketItemElement.getNameDishes());
        assertEquals(1, returnBasketItemElement.getId());
        assertEquals(new Order(), returnBasketItemElement.getOrder());
    }
}