package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Ingredients;
import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.entity.enums.NamePizza;
import com.vera1s.pizzacafe.entity.enums.SizeItem;
import com.vera1s.pizzacafe.service.interfaces.PriceMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Класс для подсчёта стоимости заказов
 */
@Service
public class PriceMenuServiceImpl implements PriceMenuService {

    private final double COEFFICIENT_LARGE_PRICE = 2.0;
    private final double COEFFICIENT_MEDIUM_PRICE = 1.5;
    private final double COEFFICIENT_SMALL_PRICE = 1.0;
    private final double COEFFICIENT_INGREDIENTS_PRICE = 3.0;


    @Transactional
    public double calculatePrice(SizeItem sizeItem, int numberOfIngredients) {
       return switch (sizeItem) {
            case LARGE -> numberOfIngredients * COEFFICIENT_LARGE_PRICE * COEFFICIENT_INGREDIENTS_PRICE;
            case MEDIUM -> numberOfIngredients * COEFFICIENT_MEDIUM_PRICE * COEFFICIENT_INGREDIENTS_PRICE;
            case SMALL -> numberOfIngredients * COEFFICIENT_SMALL_PRICE * COEFFICIENT_INGREDIENTS_PRICE;
        };
    }


    }


