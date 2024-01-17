package com.vera1s.pizzacafe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Здесь будет видно название пиццы и других блюд, напитков, размер блюда, цена
 */


@Entity
@Table(name = "menuCafe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuCafe {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String nameDishes;

   //@Enumerated(EnumType.STRING)
   //@Column(name = "ingredientsForPizza")
   //private IngredientsForPizza ingredients;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeItem sizeItem;

    @Column(name = "price")
    private double price;



}
