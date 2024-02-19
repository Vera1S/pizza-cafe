package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.BasketItem;
import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.entity.Delivery;
import com.vera1s.pizzacafe.entity.Order;
import com.vera1s.pizzacafe.entity.enums.CustomerStatus;
import com.vera1s.pizzacafe.repository.CustomerRepository;
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
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    List<Customer> customers;

    @BeforeEach
    void setUp() {
        // Создаем список пицц
        customers = new ArrayList<>();
        List<Order> orders = List.of(new Order());
        Collection<BasketItem> basketItems = List.of(new BasketItem());
        List<Delivery> deliveries = List.of(new Delivery());

        // Добавляем несколько экземпляров пицц в список
        customers.add(new Customer(12, "Client", "hj@gmail.com", "Brooklyn",
                "4525789", CustomerStatus.ACTIVE, orders, basketItems, deliveries));

        customers.add(new Customer(10, "Clients", "hjl@gmail.com", "Bay",
                "4525523", CustomerStatus.INACTIVE, orders, basketItems, deliveries));
    }

    @Test
    void getAllCustomer() {


        // Задаем поведение мокито для метода findAll()
        when(customerRepository.findAll()).thenReturn(customers);

        // Запускаем тестируемый метод
        List<Customer> returnedCustomer = customerServiceImpl.getAllCustomer();

        // Проверяем результаты теста
        assertNotNull(returnedCustomer);
        assertEquals(2, returnedCustomer.size());

        Customer returnedCustomerElement = returnedCustomer.get(0);
        assertEquals("Brooklyn", returnedCustomerElement.getAddress());
        assertEquals(12, returnedCustomerElement.getId());
    }
}