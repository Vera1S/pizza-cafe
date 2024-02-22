package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.*;

import com.vera1s.pizzacafe.repository.CustomerRepository;
import com.vera1s.pizzacafe.repository.OrderRepository;
import com.vera1s.pizzacafe.repository.PizzaRepository;
import com.vera1s.pizzacafe.service.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Класс для создания заказов, в котором хранится бизнес логика о заказах
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final CafeService cafeService;
    private final BasketItemService basketItemService;



    @Override
    @Transactional
    public Order getById(Integer id) {
        Optional<Order> optional = orderRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    @Transactional
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Order order) {
        if (order == null) {
            return;
        }
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (id != null && orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        }
    }

    @Override
    @Transactional
    public void update(Integer id, Order order) {
        Optional<Order> persistOrderOptional = orderRepository.findById(id);
        if (persistOrderOptional.isPresent()) { //если есть
            Order persistOrder = persistOrderOptional.get(); //покажи
            persistOrder.setBasketItem(order.getBasketItem());// в старое menuItem устанавливаем новое имя
            orderRepository.save(persistOrder); //пересохраняем старое menuItem
        }
    }
    @Transactional
    public void formOrder(Integer customerId, Integer cafeId) {

        Customer customer = customerService.getById(customerId);
        Collection<BasketItem> basketAllItems = customer.getBasketItem(); // все товары у клиента покажет
        double cost = 0;
        for (BasketItem item : basketAllItems) {
            cost = cost + item.getPrice() * item.getQuantity();
        }
        Order order = new Order(cost, customer);

        Cafe cafe = cafeService.getById(cafeId);
        order.setCafe(cafe);
        orderRepository.save(order); //сохранить заказ в 75 строке

        for (BasketItem item : basketAllItems) {
            item.setOrder(order);
            basketItemService.save(item);
        }
    }


}


