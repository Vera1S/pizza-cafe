package com.vera1s.pizzacafe.dto;

import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс IngredientsDTO предназначен для представления данных об ингредиентах
 * для пиццы, таких как их идентификаторы и названия.
 *
 * Он используется для передачи этих данных между классами данного приложения и
 *  * при использовании REST API.
 */
@Data
@AllArgsConstructor
public class IngredientsDTO {

    private Integer id;

    private IngredientsForPizza name;


}
