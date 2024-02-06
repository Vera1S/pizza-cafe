package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.BasketItem;

import com.vera1s.pizzacafe.entity.Order;
import com.vera1s.pizzacafe.repository.OrderRepository;
import com.vera1s.pizzacafe.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    @Override
    public Order getById(Integer id) {
        Optional<Order> optional = orderRepository.findById(id);
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        if (order == null){
            return;
        }
        orderRepository.save(order);
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null && orderRepository.existsById(id)){
            orderRepository.deleteById(id);
        }
    }

    @Override
    public void update(Integer id, Order order) {
        Optional<Order> persistOrderOptional = orderRepository.findById(id);
        if (persistOrderOptional.isPresent()) { //если есть
            Order persistOrder = persistOrderOptional.get(); //покажи
            persistOrder.setBasketItem(order.getBasketItem());// в старое menuItem устанавливаем новое имя
            orderRepository.save(persistOrder); //пересохраняем старое menuItem
        }
    }
    }

