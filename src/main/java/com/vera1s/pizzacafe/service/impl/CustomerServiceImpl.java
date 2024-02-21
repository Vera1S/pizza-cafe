package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Cafe;
import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.repository.CustomerRepository;
import com.vera1s.pizzacafe.service.interfaces.CustomerService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Customer> getAllCustomer() {
        return null;
    }

    @Override
    @Transactional
    public Customer getById(Integer id) {
        Optional<Customer> optional = customerRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void save(Customer customer) {

    }


    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (id != null && customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }

    }

    @Override
    @Transactional
    public void update(Integer id, Customer customer) {
        Optional<Customer> persistCustomerOptional = customerRepository.findById(id);
        if (persistCustomerOptional.isPresent()) { //если есть
            Customer persistCustomer = persistCustomerOptional.get();//покажи
            persistCustomer.setName(customer.getName()); //в старый customer устанавливаем новое имя
            persistCustomer.setAddress(customer.getAddress());
            persistCustomer.setId(customer.getId());
            persistCustomer.setEmail(customer.getEmail());
            persistCustomer.setOrders(customer.getOrders());
            persistCustomer.setBasketItem(customer.getBasketItem());
            persistCustomer.setDeliveries(customer.getDeliveries());
            customerRepository.save(persistCustomer); //пересохраняем старый клиент
        }
    }
}
