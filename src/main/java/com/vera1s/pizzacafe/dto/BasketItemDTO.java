package com.vera1s.pizzacafe.dto;

import com.vera1s.pizzacafe.entity.enums.SizeItem;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class BasketItemDTO {

    private Integer id;
    private String nameDishes;
    private int quantity;
    private SizeItem sizeItem;
    private double price;
}
