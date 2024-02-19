package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Cafe;
import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.entity.Delivery;
import com.vera1s.pizzacafe.entity.Order;
import com.vera1s.pizzacafe.repository.CafeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CafeServiceImplTest {

    @Mock
    private CafeRepository cafeRepository;
    @InjectMocks
    private CafeServiceImpl cafeServiceImpl;

    public List<Cafe> cafes;

    @BeforeEach
    void setUp() {
        // Создаем список пицц
        cafes = new ArrayList<>();
        List<Order> orders = List.of(new Order());
        List<Delivery> deliveries = List.of();

        // Добавляем несколько экземпляров пицц в список
        cafes.add(new Cafe(1, "Kas", "ff@gmail.com", "address",
                "phone", LocalTime.of(22, 0), orders, deliveries));
    }

    @Test
    void getAllCafe() {

        // Задаем поведение мокито для метода findAll()
        when(cafeRepository.findAll()).thenReturn(cafes);

        // Запускаем тестируемый метод
        List<Cafe> returnCafe = cafeServiceImpl.getAllCafe();

        // Проверяем результаты теста
        assertNotNull(returnCafe);
        assertEquals(1, returnCafe.size());

        Cafe returnCafeElement = returnCafe.get(0);
        assertEquals(1, returnCafeElement.getId());
        //assertEquals(LocalTime.MIDNIGHT, returnCafeElement.getStatus());
        //assertEquals(LocalTime.of(22,0), returnCafeElement.getStatus());
        assertEquals("Kas", returnCafeElement.getName());
        assertEquals("address", returnCafeElement.getAddress());
    }
}