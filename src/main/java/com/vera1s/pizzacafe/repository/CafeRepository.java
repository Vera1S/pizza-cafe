package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {

    Optional<Cafe> findById(Integer id);
}
