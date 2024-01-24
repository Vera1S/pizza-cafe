package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.repository.CustomerRepository;
import com.vera1s.pizzacafe.service.interfaces.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer getNewCustomer(Integer id) {
        List<Customer> Customer = customerRepository.findAll();

        if (Customer.isEmpty()) {
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public Customer getById(Integer id) {
        Optional<Customer> optional = customerRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }


    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            return;
        }
        customerRepository.deleteById(id);
    }
}
