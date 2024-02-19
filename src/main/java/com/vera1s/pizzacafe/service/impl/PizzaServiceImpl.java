package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Ingredients;
import com.vera1s.pizzacafe.entity.MenuItem;
import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.entity.enums.NamePizza;
import com.vera1s.pizzacafe.repository.PizzaRepository;
import com.vera1s.pizzacafe.service.interfaces.IngredientsService;
import com.vera1s.pizzacafe.service.interfaces.MenuItemService;
import com.vera1s.pizzacafe.service.interfaces.PizzaService;
import com.vera1s.pizzacafe.service.interfaces.PriceMenuService;
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
    private final PriceMenuService priceMenuService;
    private final IngredientsService ingredientsService;
    private final MenuItemService menuItemService;


    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }


    @Override
    public Pizza getById(Integer id) {
        Optional<Pizza> optional = pizzaRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null; //return pizzaRepository.findById(id).orElse(null);
        }
    }

    @Override
    public void save(Pizza pizza, Integer cafeId) {
        if (pizza == null) {
            return;
        }
        double price = priceMenuService.calculatePrice(pizza.getSizeItem(), pizza.getIngredients().size());

        MenuItem menuItem = new MenuItem();
        menuItem.setNamePizza(pizza.getNamePizza());
        menuItem.setSizeItem(pizza.getSizeItem());
        menuItem.setPrice(price);
        pizza.setMenuItem(menuItem);


        menuItemService.save(menuItem);
        pizzaRepository.save(pizza);
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null && pizzaRepository.existsById(id)) {    //если id не равно 0 и существует по идентификатору
            pizzaRepository.deleteById(id);
        }
    }

    @Override
    public void update(Integer id, Pizza pizza) {
        Optional<Pizza> persistPizzaOptional = pizzaRepository.findById(id);
        if (persistPizzaOptional.isPresent()) { //если есть
            Pizza persistPizza = persistPizzaOptional.get();
            persistPizza.setNamePizza(pizza.getNamePizza()); //в старую pizza устанавливаем новое имя
            persistPizza.setMenuItem(pizza.getMenuItem());
            pizzaRepository.save(persistPizza); //пересохраняем старую pizza
        }
    }
}
