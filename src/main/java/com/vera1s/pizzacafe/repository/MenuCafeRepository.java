package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.MenuCafeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCafeRepository extends JpaRepository<MenuCafeService, Long> {


}
