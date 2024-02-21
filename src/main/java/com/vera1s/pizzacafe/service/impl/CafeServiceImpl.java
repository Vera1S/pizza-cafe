package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Cafe;
import com.vera1s.pizzacafe.repository.CafeRepository;
import com.vera1s.pizzacafe.service.interfaces.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {

private final CafeRepository cafeRepository;
    @Override
    @Transactional
    public Cafe getById(Integer id) {
        Optional<Cafe> optional = cafeRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null; //return cafeRepository.findById(id).orElse(null);
        }
    }

    @Override
    @Transactional
    public List<Cafe> getAllCafe() {
        return cafeRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Cafe cafe) {
        if (cafe == null){
            return;
        }
        cafeRepository.save(cafe);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (id != null && cafeRepository.existsById(id)){  //если id не равно 0 и существует по идентификатору
            cafeRepository.deleteById(id);
        }
    }

    @Override
    @Transactional
    public void update(Integer id, Cafe cafe) {
        Optional<Cafe> persistCafeOptional = cafeRepository.findById(id);
        if (persistCafeOptional.isPresent()) { //если есть
            Cafe persistCafe = persistCafeOptional.get();//покажи
            persistCafe.setName(cafe.getName()); //в старое cafe устанавливаем новое имя
            cafeRepository.save(persistCafe); //пересохраняем старое cafe
        }
    }}
