package com.vera1s.pizzacafe.service.interfaces;


import com.vera1s.pizzacafe.entity.Order;

import java.util.List;

public interface OrderService {
   Order getById(Integer id);

    List<Order> getAllOrder();

    void save(Order order);

    void deleteById(Integer id);

    void update(Integer id, Order order);

    void formOrder(Integer customerId);

}
