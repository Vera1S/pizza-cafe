package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.entity.enums.NamePizzaEnum;
import com.vera1s.pizzacafe.repository.PizzaRepository;
import com.vera1s.pizzacafe.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

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
            persistPerson.setNamePizzaEnum(pizza.getNamePizzaEnum()); //в старую pizza устанавливаем новое имя
            pizzaRepository.save(persistPerson); //пересохраняем старую pizza
        }
    }
  // private static Pizza createPizza(Integer id, NamePizzaEnum pizzaEnum, IngredientsForPizza ingredients) {

   //    Integer pizzaId ;
   //    Pizza pizza = new Pizza(Integer id, pizzaEnum.toString(), ingredients, sizeItem);

   //    return pizza;
}
