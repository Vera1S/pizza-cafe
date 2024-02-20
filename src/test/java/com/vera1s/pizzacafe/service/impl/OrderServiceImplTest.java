package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.*;
import com.vera1s.pizzacafe.repository.OrderRepository;
import com.vera1s.pizzacafe.service.interfaces.CustomerService;
import com.vera1s.pizzacafe.service.interfaces.PizzaService;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerService customerService;

    @Mock
    private PizzaService pizzaService;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;

    private List<Order> orders;

    @BeforeEach
    void setUp() {
        // Создаем список пицц
        orders = new ArrayList<>();
        Collection<BasketItem> basketItems = List.of();

        // Добавляем несколько экземпляров пицц в список
        orders.add(new Order(1, 3.50, new Customer(), new Cafe(), basketItems, new Delivery()));
    }

    @Test
    public void getAllOrder(){

        // Задаем поведение мокито для метода findAll()
        when(orderRepository.findAll()).thenReturn(orders);

        // Запускаем тестируемый метод
        List<Order> returnedOrder = orderServiceImpl.getAllOrder();

        // Проверяем результаты теста
        assertNotNull(returnedOrder);
        assertEquals(1, returnedOrder.size());
       // assertEquals(1, returnedOrder.get(1));
    }
}