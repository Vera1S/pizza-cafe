package com.vera1s.pizzacafe.service.interfaces;

import com.vera1s.pizzacafe.entity.Cafe;


import java.util.List;

public interface CafeService {

    Cafe getById(Integer id);

    List<Cafe> getAllCafe();

    void save(Cafe cafe);

    void deleteById(Integer id);

    void update(Integer id, Cafe cafe);
}
