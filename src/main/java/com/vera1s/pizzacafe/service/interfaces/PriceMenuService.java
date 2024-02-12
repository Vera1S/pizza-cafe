package com.vera1s.pizzacafe.service.interfaces;

import com.vera1s.pizzacafe.entity.enums.SizeItem;

public interface PriceMenuService {

    double calculatePrice(SizeItem sizeItem, double price);
}
