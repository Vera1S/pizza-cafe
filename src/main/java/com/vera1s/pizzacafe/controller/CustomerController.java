package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.dto.CustomerDTO;
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
    public CustomerDTO getPizzaById(@PathVariable(value = "id")Integer id){
        Customer customers = customerService.getById(id);
        CustomerDTO customerDTO = new CustomerDTO(customers.getId(), customers.getName(), customers.getEmail(),
                customers.getAddress(), customers.getPhone(), customers.getStatus());
        return customerDTO;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomer();
        List<CustomerDTO> customerDTOS = customers.stream()
                .map(customer -> new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail(),
                        customer.getAddress(), customer.getPhone(), customer.getStatus()))
                .toList();
        return ResponseEntity.ok(customerDTOS);
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
    public void updateCustomerById(@PathVariable(value = "id")Integer id,
                                   @RequestBody Customer customer){
        customerService.update(id, customer);
    }
}
