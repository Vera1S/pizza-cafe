package com.vera1s.pizzacafe.service.interfaces;

import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface MenuCafeService {

    com.vera1s.pizzacafe.entity.MenuCafeService getNameDishes();

    List<com.vera1s.pizzacafe.entity.MenuCafeService> getNameByDishes(String nameDishes);

}
