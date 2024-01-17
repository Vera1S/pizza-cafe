package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.MenuCafe;
import com.vera1s.pizzacafe.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {


}
