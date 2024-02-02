package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.NamePizzaEnum;
import com.vera1s.pizzacafe.entity.enums.SizeItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Здесь будет видно название пиццы и других блюд, напитков, размер блюда, цена
 */


@Entity
@Table(name = "menu_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name_Pizza")
    private NamePizzaEnum namePizzaEnum;  //только пиццу убрать енам и сделать строку

        @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeItem sizeItem;

    @Column(name = "price")
    private double price;

    @ManyToOne
    private Cafe cafe;

    @OneToMany(mappedBy = "menuItem")
    private List<Pizza> pizzas;

    @OneToMany(mappedBy = "menuItem")
    private List<BasketItem> basketItems;

}