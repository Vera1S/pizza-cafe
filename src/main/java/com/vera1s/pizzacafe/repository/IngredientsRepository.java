package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {

}
