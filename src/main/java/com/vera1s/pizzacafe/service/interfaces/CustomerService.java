package com.vera1s.pizzacafe.service.interfaces;


import com.vera1s.pizzacafe.entity.Customer;

public interface CustomerService {

    Customer getNewCustomer(Integer id);

    Customer getById(Integer id);

    void deleteById(Integer id);

}
