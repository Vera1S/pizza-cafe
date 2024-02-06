package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.entity.Delivery;
import com.vera1s.pizzacafe.service.interfaces.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping(value = "/id")
    public Delivery getDeliveryById(@PathVariable(value = "id")Integer id){
        Delivery delivery = deliveryService.getById(id);
        return delivery;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Delivery>> getAllDelivery() {
        List<Delivery> delivery = deliveryService.getAllDelivery();
        return ResponseEntity.ok(delivery);
    }
    @PostMapping(value = "/save")
    public void saveDelivery(@RequestBody Delivery delivery){
        deliveryService.save(delivery);
    }

    @DeleteMapping(value = "/delete")
    public void deleteById(@PathVariable(value = "id")Integer id){
        deliveryService.deleteById(id);
    }

    @PutMapping(value = "/update")
    public void updateById(@PathVariable(value = "id")Integer id, @RequestBody Delivery delivery){
        deliveryService.update(id, delivery);
    }
}
