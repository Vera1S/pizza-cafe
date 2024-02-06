package com.vera1s.pizzacafe.service.impl;


import com.vera1s.pizzacafe.entity.Delivery;
import com.vera1s.pizzacafe.repository.DeliveryRepository;
import com.vera1s.pizzacafe.service.interfaces.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    public Delivery getById(Integer id) {
        Optional<Delivery> optional = deliveryRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null; //return deliveryRepository.findById(id).orElse(null);
        }
    }

    @Override
    public List<Delivery> getAllDelivery() {
        return deliveryRepository.findAll();
    }

    @Override
    public void save(Delivery delivery) {
        if (delivery == null) {
            return;
        }
        deliveryRepository.save(delivery);
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null && deliveryRepository.existsById(id)){
            deliveryRepository.deleteById(id);
        }
    }

    @Override
    public void update(Integer id, Delivery delivery) {
        Optional<Delivery> persistDeliveryOptional = deliveryRepository.findById(id);
        if (persistDeliveryOptional.isPresent()) { //если есть
            Delivery persistDelivery = persistDeliveryOptional.get();//покажи
          //  persistDelivery.setName(delivery.getName()); //в старый BasketItem устанавливаем новое имя
   // все поля обновить
            deliveryRepository.save(persistDelivery); //пересохраняем старую доставку
        }
    }
}
