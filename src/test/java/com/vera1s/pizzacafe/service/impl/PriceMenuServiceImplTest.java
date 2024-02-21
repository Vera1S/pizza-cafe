package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.enums.SizeItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PriceMenuServiceImplTest {

    @InjectMocks
    private PriceMenuServiceImpl priceMenuServiceImpl;



    @Test
    void calculatePrice() {

        double returnedPrice = priceMenuServiceImpl.calculatePrice(SizeItem.LARGE, 2);

        assertEquals(12, returnedPrice);

    }
}