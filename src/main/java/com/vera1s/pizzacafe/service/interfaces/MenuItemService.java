package com.vera1s.pizzacafe.service.interfaces;


import com.vera1s.pizzacafe.entity.MenuItem;


import java.util.List;

public interface MenuItemService {

    MenuItem getById(Integer id);

    List<MenuItem> getAllCafe();

    void save(MenuItem menuItem);

    void deleteById(Integer id);

    void update(Integer id, MenuItem menuItem);

}
