package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.service.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/id")
    public Customer getPizzaById(@PathVariable(value = "id")Integer id){
        Customer customers = customerService.getById(id);
        return customers;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }
    @PostMapping(value = "/save")
    public void saveCustomer(@RequestBody Customer customers){
        customerService.save(customers);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id")Integer id){
        customerService.deleteById(id);
    }

    @PutMapping(value = "/update/{id}")
    public void updateCustomerById(@PathVariable(value = "id")Integer id, @RequestBody Customer customer){
        customerService.update(id, customer);
    }
}
