package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Cafe;
import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.repository.CustomerRepository;
import com.vera1s.pizzacafe.service.interfaces.CustomerService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

//    @Override
//    public Customer getNewCustomer(Integer id) {
//        List<Customer> Customer = customerRepository.findAll();
//
//        if (Customer.isEmpty()) {
//            throw new RuntimeException();
//        }
//        return null;
//    }

    @Override
    public List<Customer> getAllCustomer() {
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
    public void save(Customer customer) {

    }


    @Override
    public void deleteById(Integer id) {
        if (id != null && customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }

    }

    @Override
    public void update(Integer id, Customer customer) {
        Optional<Customer> persistCustomerOptional = customerRepository.findById(id);
        if (persistCustomerOptional.isPresent()) { //если есть
            Customer persistCustomer = persistCustomerOptional.get();//покажи
            persistCustomer.setName(customer.getName()); //в старый customer устанавливаем новое имя
            //обновдение каждого поле
            customerRepository.save(persistCustomer); //пересохраняем старый клиент
        }
    }
}
