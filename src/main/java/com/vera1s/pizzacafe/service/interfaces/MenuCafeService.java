package com.vera1s.pizzacafe.service.interfaces;

import com.vera1s.pizzacafe.entity.MenuItem;


import java.util.List;
//@Service
public interface MenuCafeService {

    MenuItem getNameDishes();

    List<MenuItem> getNameByDishes(String nameDishes);

}
