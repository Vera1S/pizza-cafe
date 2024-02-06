package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem, Integer> {
    Optional<BasketItem> findById(Integer id);
}
