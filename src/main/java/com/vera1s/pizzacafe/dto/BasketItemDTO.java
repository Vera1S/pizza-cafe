package com.vera1s.pizzacafe.dto;

import com.vera1s.pizzacafe.entity.enums.SizeItem;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class BasketItemDTO {

    private Integer id;
    private String nameDishes;
    private int quantity;
    private SizeItem sizeItem;
    private double price;
}
