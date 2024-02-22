package com.vera1s.pizzacafe.dto;

import com.vera1s.pizzacafe.entity.enums.SizeItem;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Этот класс, MenuItemDTO, используется для представления данных о пунктах меню,
 *  таких как их идентификаторы, названия, размеры и цены.
 *
 *  Он используется для передачи этих данных между классами данного приложения и
 *  * при использовании REST API.
 */
@Data
@AllArgsConstructor
public class MenuItemDTO {

    private Integer id;


    private String namePizza;


    private SizeItem sizeItem;


    private double price;
}
