package com.vera1s.pizzacafe.dto;

import com.vera1s.pizzacafe.entity.enums.SizeItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuItemDTO {

    private Integer id;


    private String namePizza;


    private SizeItem sizeItem;


    private double price;
}
