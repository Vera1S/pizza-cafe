package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.*;
import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.entity.enums.SizeItem;
import com.vera1s.pizzacafe.repository.MenuItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MenuItemServiceImplTest {

    @Mock
    private MenuItemRepository menuItemRepository;

    @InjectMocks
    private MenuItemServiceImpl menuItemServiceImpl;

    private List<MenuItem> menuItems;
    private List<BasketItem> basketItems;
    private List<Pizza> pizzas;

    @BeforeEach
    void setUp() {
        // Создаем список пицц
        menuItems = new ArrayList<>();
       // List<Pizza> pizzas = List.of(new Pizza(1, IngredientsForPizza.TOMATOES.name(), SizeItem.MEDIUM, null));

        // Добавляем несколько экземпляров пицц в список
        menuItems.add(new MenuItem(1, "apple", SizeItem.LARGE, 4.3, new Cafe(),
                pizzas, basketItems));
    }
    @Test
    public void getAllMenuItem(){

        // Задаем поведение мокито для метода findAll()
        when(menuItemRepository.findAll()).thenReturn(menuItems);

        // Запускаем тестируемый метод
        List<MenuItem> returnedMenuItem = menuItemServiceImpl.getAllMenuItem();

        // Проверяем результаты теста
        assertNotNull(returnedMenuItem);
        assertEquals(1, returnedMenuItem.size());

        MenuItem returnedMenuItemElement = returnedMenuItem.get(0);
        assertEquals(1, returnedMenuItemElement.getId());
        assertEquals("apple", returnedMenuItemElement.getNamePizza());
        assertEquals(SizeItem.LARGE, returnedMenuItemElement.getSizeItem());
        assertEquals(pizzas, returnedMenuItemElement.getPizzas());
    }

    }