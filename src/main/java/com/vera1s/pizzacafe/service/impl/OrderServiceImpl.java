package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.BasketItem;

import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.entity.Order;
import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.repository.CustomerRepository;
import com.vera1s.pizzacafe.repository.OrderRepository;
import com.vera1s.pizzacafe.repository.PizzaRepository;
import com.vera1s.pizzacafe.service.interfaces.CustomerService;
import com.vera1s.pizzacafe.service.interfaces.OrderService;
import com.vera1s.pizzacafe.service.interfaces.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;



    @Override
    @Transactional
    public Order getById(Integer id) {
        Optional<Order> optional = orderRepository.findById(id);
        return orderRepository.findById(id).orElse(null);
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
    public void formOrder(Integer customerId) {

        Customer customer = customerService.getById(customerId);
        Collection<BasketItem> basketAllItems = customer.getBasketItem(); // все товары у клиента покажет
        double cost = 0;
        for (BasketItem item : basketAllItems) {
            cost = cost + item.getPrice() * item.getQuantity();
        }
        Order order = new Order(cost, customer);
        orderRepository.save(order); //сохранить заказ в 75 строке
    }


}


