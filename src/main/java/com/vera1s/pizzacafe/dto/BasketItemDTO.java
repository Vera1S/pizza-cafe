package com.vera1s.pizzacafe.dto;

import com.vera1s.pizzacafe.entity.enums.SizeItem;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс DTO создан для того, чтобы уменьшить объем передаваемых данных по сети.
 * Использование DTO позволяет избежать передачи большого количества
 * неиспользуемых данных и снять лишнюю нагрузку с сети.
 *
 * В данном случае, каждый объект класса BasketItemDTO будет
 * представлять информацию о товаре в корзине.
 *
 * Класс BasketItemDTO используется для описания товаров, которые пользователь
 * добавляет в корзину при покупке. Он позволяет хранить и передавать
 * информацию о товарах между различными частями программы (например,
 * между интерфейсом пользователя и базой данных).
 */
@Data
@AllArgsConstructor
public class BasketItemDTO {

    private Integer id;
    private String nameDishes;
    private int quantity;
    private SizeItem sizeItem;
    private double price;
}
