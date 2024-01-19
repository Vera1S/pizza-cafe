package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.enums.SizeItem;

public class PriceMenuServiceImpl {

    private final double COEFFICIENT_LARGE_PRICE = 2.0;
    private final double COEFFICIENT_MEDIUM_PRICE = 1.5;
    private final double COEFFICIENT_SMALL_PRICE = 1.0;


    public PriceMenuServiceImpl(SizeItem sizeItem, int price) {
        if (sizeItem == SizeItem.LARGE) {
            System.out.println(price * COEFFICIENT_LARGE_PRICE);
        } else if (sizeItem == SizeItem.MEDIUM) {
            System.out.println(price * COEFFICIENT_MEDIUM_PRICE);
        } else if (sizeItem == SizeItem.SMALL) {
            System.out.println(COEFFICIENT_SMALL_PRICE);
        } else {
            System.out.println("Invalid sizeItem");


        }
    }


}
