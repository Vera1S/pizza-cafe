package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.BasketItem;
import com.vera1s.pizzacafe.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem, Integer> {
    Optional<BasketItem> findById(Integer id);

    Collection<BasketItem> findAllByCustomers(Customer customer);
}
