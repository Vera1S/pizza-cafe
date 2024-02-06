package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

    Optional<MenuItem> findById(Integer id);
}
