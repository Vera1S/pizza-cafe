package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Cafe;
import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.entity.Delivery;
import com.vera1s.pizzacafe.entity.Order;
import com.vera1s.pizzacafe.entity.enums.DriverStatus;
import com.vera1s.pizzacafe.repository.DeliveryRepository;
import com.vera1s.pizzacafe.service.interfaces.CustomerService;
import com.vera1s.pizzacafe.service.interfaces.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeliveryServiceImplTest {

    @Mock
    private DeliveryRepository deliveryRepository;
    @Mock
    private CustomerService customerService;
    @Mock
    private OrderService orderService;

    @InjectMocks
    private DeliveryServiceImpl deliveryServiceImpl;

    List<Delivery> deliveries;
    Collection<Delivery> deliveryCollection;

    @BeforeEach
    void setUp() {
        // Создаем список пицц
        deliveries = new ArrayList<>();
        deliveryCollection = new ArrayList<>();

        // Добавляем несколько экземпляров пицц в список
        deliveries.add(new Delivery(1, DriverStatus.DISPATCHED, new Order(),
                new Customer(), new Cafe()));
        deliveryCollection.add(new Delivery(2, DriverStatus.PENDING, new Order(),
                new Customer(), new Cafe()));
    }

    @Test
    void getAllDelivery() {
            // Задаем поведение мокито для метода findAll()
        when(deliveryRepository.findAll()).thenReturn(deliveries);

        // Запускаем тестируемый метод
        List<Delivery> returnedDelivery = deliveryServiceImpl.getAllDelivery();

        // Проверяем результаты теста
        assertNotNull(returnedDelivery);
        assertEquals(1, returnedDelivery.size());

        Delivery returnedDeliveryElement = returnedDelivery.get(0);
        assertEquals(1, returnedDeliveryElement.getId());
        assertEquals(DriverStatus.DISPATCHED, returnedDeliveryElement.getDriverStatus());
        }

        @Test
    void getAllByCustomer(){

            // Задаем поведение мокито для метода findAll()
            when(deliveryRepository.findAll()).thenReturn((List<Delivery>) deliveryCollection);

            // Запускаем тестируемый метод
            Collection<Delivery> returnedDeliveryCustomer =
                    deliveryServiceImpl.getAllByCustomer(new Customer());

            // Проверяем результаты теста
            assertNotNull(returnedDeliveryCustomer);
            assertEquals(1, returnedDeliveryCustomer.size());

            Delivery returnedDeliveryCustomerElement = returnedDeliveryCustomer.iterator().next();
            assertEquals(2, returnedDeliveryCustomerElement.getId());
            assertEquals(DriverStatus.PENDING, returnedDeliveryCustomerElement.getDriverStatus());
        }
    }
