package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Ingredients;
import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.entity.enums.SizeItem;
import com.vera1s.pizzacafe.repository.PizzaRepository;
import com.vera1s.pizzacafe.service.interfaces.IngredientsService;
import com.vera1s.pizzacafe.service.interfaces.PriceMenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.vera1s.pizzacafe.entity.enums.NamePizza.CHEESE;
import static com.vera1s.pizzacafe.entity.enums.NamePizza.MARGARITA;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PizzaServiceImplTest {

    @Mock
    private PizzaRepository pizzaRepository;
    @Mock
    private PriceMenuService priceMenuService;

    @Mock
    private IngredientsService ingredientsService;

    @InjectMocks
    private PizzaServiceImpl pizzaServiceImpl;

    private List<Pizza> pizzas;

        @BeforeEach
    void setUp() {
        // Создаем список пицц
        pizzas = new ArrayList<>();
        List<Ingredients> ingredients = List.of(new Ingredients(1, IngredientsForPizza.CHEESE),
                new Ingredients(2, IngredientsForPizza.TOMATOES));

        // Добавляем несколько экземпляров пицц в список
       pizzas.add(new Pizza(0, MARGARITA.name(), ingredients, SizeItem.LARGE, null));
       pizzas.add(new Pizza(1, CHEESE.name(), ingredients, SizeItem.SMALL, null));
    }

    @Test
    public void getAllPizzas(){

        // Задаем поведение мокито для метода findAll()
        when(pizzaRepository.findAll()).thenReturn(pizzas);

        // Запускаем тестируемый метод
        List<Pizza> returnedPizzas = pizzaServiceImpl.getAllPizzas();

        // Проверяем результаты теста
        assertNotNull(returnedPizzas);
       assertEquals(2, returnedPizzas.size());

       Pizza returnPizzaElement = returnedPizzas.get(0);
       assertEquals("MARGARITA", returnPizzaElement.getNamePizza());
       assertEquals(SizeItem.LARGE, returnPizzaElement.getSizeItem());

        Pizza returnPizzaElementSecond = returnedPizzas.get(1);
        assertEquals(SizeItem.SMALL, returnPizzaElementSecond.getSizeItem());
        assertEquals("CHEESE", returnPizzaElementSecond.getNamePizza());
    }
    @Test
    public void getAllPizzasEmpty(){

        // Задаем поведение мокито для метода findAll()
        when(pizzaRepository.findAll()).thenReturn(new ArrayList<>());

        // Запускаем тестируемый метод
        List<Pizza> returnedPizzas = pizzaServiceImpl.getAllPizzas();

        // Проверяем результаты теста
        assertEquals(0, returnedPizzas.size());
    }

    @Test
    public void getById(){

        Optional<Pizza> returnedOptional = Optional.of(pizzas.get(0));

        //задание начальных значений
       when(pizzaRepository.findById(0)).thenReturn(returnedOptional);

        //запустить сам метод
        Pizza returnedPizzasId = pizzaServiceImpl.getById(0);

        // Проверяем результаты теста
        assertEquals(0, returnedPizzasId.getId());
    }
}