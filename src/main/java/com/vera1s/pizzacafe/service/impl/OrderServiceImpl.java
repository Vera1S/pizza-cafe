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

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final PizzaService pizzaService;


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
        if (order == null) {
            return;
        }
        orderRepository.save(order);
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null && orderRepository.existsById(id)) {
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

    public void formOrder(Integer customerId) {
        // Забрать пиццу и клиент

        Customer customer = customerService.getById(customerId);
        Collection<BasketItem> basketAllItems = customer.getBasketItem(); // все товары у клиента покажет
        double cost = 0;
        for (BasketItem item : basketAllItems) {
            cost = cost + item.getPrice() * item.getQuantity();
        }
        Order order = new Order(cost, customer);
        orderRepository.save(order); //сохранить заказ в 75 строке
    }

    // Проверьте, существуют ли как пицца, так и клиент
    // if (customer == null) {
//            throw new IllegalArgumentException("Invalid pizza or customer"); //Недействительная пицца или клиент
//    }
}


