package com.vera1s.pizzacafe.service.interfaces;


import com.vera1s.pizzacafe.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomer();

    Customer getById(Integer id);
    void save(Customer customer);

    void deleteById(Integer id);

    void update(Integer id, Customer customer);

}
