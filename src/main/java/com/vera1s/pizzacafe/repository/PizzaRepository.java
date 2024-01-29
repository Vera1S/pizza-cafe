package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

    Optional<Pizza> findById(Integer id);

}
