package com.vera1s.pizzacafe.service;

import com.vera1s.pizzacafe.entity.MenuCafe;


import java.util.List;

public interface CafeService {

    MenuCafe getNameDishes();

    List<MenuCafe> getNameByDishes(String nameDishes);

}
