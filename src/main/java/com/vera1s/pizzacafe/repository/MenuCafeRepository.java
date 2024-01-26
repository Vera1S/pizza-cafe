package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.MenuCafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCafeRepository extends JpaRepository<MenuCafe, Long> {


}
