package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.entity.Order;
import com.vera1s.pizzacafe.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "/id")
    public Order getOrderById(@PathVariable(value = "id")Integer id){
        Order order = orderService.getById(id);
        return order;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrder();
        return ResponseEntity.ok(orders);
    }
    @PostMapping(value = "/save")
    public void saveOrder(@RequestBody Order order){
        orderService.save(order);
    }
    @DeleteMapping(value = "/delete")
    public void deleteById(@PathVariable(value = "id")Integer id){
        orderService.deleteById(id);
    }
    @PutMapping(value = "/update/")
    public void updateOrderById(@PathVariable(value = "id")Integer id, @RequestBody Order order){
        orderService.update(id, order);
    }
}
