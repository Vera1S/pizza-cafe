package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.dto.OrderDTO;
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
    public OrderDTO getOrderById(@PathVariable(value = "id")Integer id){
        Order order = orderService.getById(id);
        OrderDTO orderDTO = new OrderDTO(order.getId(), order.getPrice());
        return orderDTO;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<Order> orders = orderService.getAllOrder();
        List<OrderDTO> orderDTOS = orders.stream()
                .map(order -> new OrderDTO(order.getId(), order.getPrice()))
                .toList();
        return ResponseEntity.ok(orderDTOS);
    }

    @PostMapping(value = "/save")
    public void saveOrder(@RequestBody Order order){
        orderService.save(order);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id")Integer id){
        orderService.deleteById(id);
    }
    @PutMapping(value = "/update/{id}")
    public void updateOrderById(@PathVariable(value = "id")Integer id, @RequestBody Order order){
        orderService.update(id, order);
    }
    @PostMapping(value = "/form-order/{id}")
    public void formOrderById(@PathVariable(value = "id")Integer id){
        orderService.formOrder(id);
    }
}
