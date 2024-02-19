package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Ingredients;

import com.vera1s.pizzacafe.repository.IngredientsRepository;
import com.vera1s.pizzacafe.service.interfaces.IngredientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientsRepository ingredientsRepository;


    @Override
    public Ingredients getById(Integer id) {
        Optional<Ingredients> optional = ingredientsRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null; //return ingredientsRepository.findById(id).orElse(null);
        }
    }

    @Override
    public List<Ingredients> getAllIngredients() {
        return ingredientsRepository.findAll();
    }

    @Override
    public void save(Ingredients ingredients) {
        if (ingredients == null){
            return;
        }
        ingredientsRepository.save(ingredients);
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null && ingredientsRepository.existsById(id)) {    //если id не равно 0 и существует по идентификатору
            ingredientsRepository.deleteById(id);
        }
    }
    @Override
    public void update(Integer id, Ingredients ingredients) {
        Optional<Ingredients> persistIngredientsOptional = ingredientsRepository.findById(id);
        if (persistIngredientsOptional.isPresent()) { //если есть
            Ingredients persistIngredients =  persistIngredientsOptional.get();//покажи
            persistIngredients.setName(ingredients.getName()); //в старый Ingredients устанавливаем новое имя
            ingredientsRepository.save(persistIngredients); //пересохраняем старый ingredients
        }
    }

    }

