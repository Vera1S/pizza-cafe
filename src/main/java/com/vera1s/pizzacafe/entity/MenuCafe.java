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
@Table(name = "menu_cafe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuCafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_cafe_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

    @Enumerated(EnumType.STRING)
    @Column(name = "name_Pizza")
    private NamePizzaEnum namePizzaEnum;  //только пиццу

        @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeItem sizeItem;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "menu_cafe")
    private List<Pizza> pizzas;



}
