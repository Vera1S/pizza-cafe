package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.enums.SizeItem;
import com.vera1s.pizzacafe.service.interfaces.PriceMenuService;
import org.springframework.stereotype.Service;

@Service
public class PriceMenuServiceImpl implements PriceMenuService {

    private final double COEFFICIENT_LARGE_PRICE = 2.0;
    private final double COEFFICIENT_MEDIUM_PRICE = 1.5;
    private final double COEFFICIENT_SMALL_PRICE = 1.0;


    public double calculatePrice(SizeItem sizeItem, double price) {
       return switch (sizeItem) {
            case LARGE -> price * COEFFICIENT_LARGE_PRICE;
            case MEDIUM -> price * COEFFICIENT_MEDIUM_PRICE;
            case SMALL -> price * COEFFICIENT_SMALL_PRICE;
        };


    }

}
