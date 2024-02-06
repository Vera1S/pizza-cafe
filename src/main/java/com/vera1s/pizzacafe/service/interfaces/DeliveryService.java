package com.vera1s.pizzacafe.service.interfaces;


import com.vera1s.pizzacafe.entity.Delivery;

import java.util.List;

public interface DeliveryService {

    Delivery getById (Integer id);
    List<Delivery> getAllDelivery();

    void save(Delivery delivery);
    void deleteById(Integer id);

    void update(Integer id, Delivery delivery);
}
