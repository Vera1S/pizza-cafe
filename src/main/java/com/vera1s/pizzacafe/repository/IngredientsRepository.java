package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.Ingredients;
import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {

  //  Optional<Ingredients> findByName(IngredientsForPizza name);
}
