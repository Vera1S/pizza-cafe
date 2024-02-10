package com.vera1s.pizzacafe.service.interfaces;


import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.entity.Delivery;

import java.util.Collection;
import java.util.List;

public interface DeliveryService {

    Delivery getById (Integer id);
    List<Delivery> getAllDelivery();

    Collection<Delivery> getAllByCustomer(Customer customer);

    void save(Delivery delivery);
    void deleteById(Integer id);

    void update(Integer id, Delivery delivery);
}
