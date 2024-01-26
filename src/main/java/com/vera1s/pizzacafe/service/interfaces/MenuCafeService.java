package com.vera1s.pizzacafe.service.interfaces;

import com.vera1s.pizzacafe.entity.MenuCafe;
import org.springframework.stereotype.Service;


import java.util.List;
//@Service
public interface MenuCafeService {

    MenuCafe getNameDishes();

    List<MenuCafe> getNameByDishes(String nameDishes);

}
