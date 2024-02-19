package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Ingredients;
import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.repository.IngredientsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IngredientsServiceImplTest {

    @Mock
    private IngredientsRepository ingredientsRepository;

    @InjectMocks
    private IngredientsServiceImpl ingredientsServiceImpl;

    private List<Ingredients> ingredients;

    @BeforeEach
    void setUp() {
        // Создаем список пицц
        ingredients = new ArrayList<>();

        // Добавляем несколько экземпляров пицц в список
        ingredients.add(new Ingredients(4, IngredientsForPizza.SEAFOOD));
        ingredients.add(new Ingredients(5, IngredientsForPizza.VEGETABLES));
    }

    @Test
    public void getAllIngredients() {

        // Задаем поведение мокито для метода findAll()
        when(ingredientsRepository.findAll()).thenReturn(ingredients);

        // Запускаем тестируемый метод
        List<Ingredients> returnedIngredients = ingredientsServiceImpl.getAllIngredients();

        // Проверяем результаты теста
        assertNotNull(returnedIngredients);
        assertEquals(2, returnedIngredients.size());

        Ingredients returnedIngredientsElement = returnedIngredients.get(0);
        assertEquals(IngredientsForPizza.SEAFOOD, returnedIngredientsElement.getName());
        assertEquals(4, returnedIngredientsElement.getId());

        Ingredients returnedIngredientsElementSecond = returnedIngredients.get(1);
        assertEquals("VEGETABLES", returnedIngredientsElementSecond.getName().name());
        assertEquals(5, returnedIngredientsElementSecond.getId());
    }
    @Test
    public void getAllIsPresent(){
        // Задаем поведение мокито для метода findAll()
        when(ingredientsRepository.findAll()).thenReturn(new ArrayList<>());

        // Запускаем тестируемый метод
        List<Ingredients> returnedIngredients = ingredientsServiceImpl.getAllIngredients();

        // Проверяем результаты теста
        assertEquals(0, returnedIngredients.size());
    }

}