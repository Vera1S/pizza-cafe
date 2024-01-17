package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.repository.PizzaRepository;
import com.vera1s.pizzacafe.service.PizzaCookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaCookingService {

    private final PizzaRepository pizzaRepository;

    @Override
    public Pizza getNewPizza(Integer id) {
        List<Pizza> Pizza = pizzaRepository.findAll();

        if (Pizza.isEmpty()) {
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public Pizza getById(Integer id) {
        Optional<Pizza> optional = pizzaRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public void save(Pizza pizza) {
        if (pizza == null){
            return;
        }
        pizzaRepository.save(pizza);
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            return;
        }
        pizzaRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, Pizza pizza) {
        Optional<Pizza> persistPizzaOptional = pizzaRepository.findById(id);
        if (persistPizzaOptional.isPresent()) { //если есть
            Pizza persistPerson = persistPizzaOptional.get();
            persistPerson.setName(pizza.getName()); //в старую pizza устанавливаем новое имя
            pizzaRepository.save(persistPerson); //пересохраняем старую pizza
        }
    }
}
