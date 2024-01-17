package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.SizeItem;

public class PriceMenuServiceImpl {

    private final double price = 10;

    public PriceMenuServiceImpl(SizeItem sizeItem, int price) {
        if (sizeItem == SizeItem.LARGE) {
            System.out.println(price * 2);
        } else if (sizeItem == SizeItem.MEDIUM) {
            System.out.println(price * 1.5);
        } else if (sizeItem == SizeItem.SMALL) {
            System.out.println(price);
        } else {
            System.out.println("Invalid sizeItem");


        }
    }


}
