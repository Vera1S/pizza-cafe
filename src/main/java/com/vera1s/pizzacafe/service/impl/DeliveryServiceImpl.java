package com.vera1s.pizzacafe.service.impl;


import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.entity.Delivery;
import com.vera1s.pizzacafe.entity.enums.DriverStatus;
import com.vera1s.pizzacafe.repository.DeliveryRepository;
import com.vera1s.pizzacafe.service.interfaces.CustomerService;
import com.vera1s.pizzacafe.service.interfaces.DeliveryService;
import com.vera1s.pizzacafe.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;


    @Override
    @Transactional
    public Delivery getById(Integer id) {
        Optional<Delivery> optional = deliveryRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null; //return deliveryRepository.findById(id).orElse(null);
        }
    }

    @Override
    @Transactional
    public List<Delivery> getAllDelivery() {
        return deliveryRepository.findAll();
    }

    @Override
    @Transactional
    public Collection<Delivery> getAllByCustomer(Customer customer) {
        return deliveryRepository.findAllByCustomers(customer);
    }

    @Override
    @Transactional
    public void save(Delivery delivery) {
        if (delivery == null) {
            return;
        }
        deliveryRepository.save(delivery);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (id != null && deliveryRepository.existsById(id)){
            deliveryRepository.deleteById(id);
        }
    }

    @Override
    @Transactional
    public void update(Integer id, Delivery delivery) {
        Optional<Delivery> persistDeliveryOptional = deliveryRepository.findById(id);
        if (persistDeliveryOptional.isPresent()) { //если есть
            Delivery persistDelivery = persistDeliveryOptional.get();//покажи
            persistDelivery.setId(delivery.getId()); //в старый BasketItem устанавливаем новое имя
            persistDelivery.setCustomers(delivery.getCustomers());
            DriverStatus calculateStated = calculateStatus(persistDelivery, delivery);
            persistDelivery.setDriverStatus(calculateStated);
            persistDelivery.setOrder(delivery.getOrder());
            deliveryRepository.save(persistDelivery); //пересохраняем старую доставку
        }
    }

    private DriverStatus calculateStatus(Delivery persistDelivery, Delivery newDelivery){
        if (persistDelivery == null){
            return DriverStatus.ERROR;
        }
        DriverStatus persistDeliveryDriverStatus = persistDelivery.getDriverStatus();
        DriverStatus newDriverStatus = newDelivery.getDriverStatus();
        if (newDriverStatus == DriverStatus.FAILED && persistDeliveryDriverStatus != DriverStatus.PENDING
                && persistDeliveryDriverStatus != DriverStatus.DISPATCHED){
            return DriverStatus.FAILED;
        }
        if (persistDeliveryDriverStatus == DriverStatus.PENDING && newDriverStatus == DriverStatus.DISPATCHED){
            return DriverStatus.DISPATCHED;
        }
        if (persistDeliveryDriverStatus == DriverStatus.DISPATCHED && newDriverStatus == DriverStatus.DELIVERED){
            return DriverStatus.DELIVERED;
        }
        return persistDeliveryDriverStatus;
    }


}
