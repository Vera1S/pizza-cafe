package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.SizeItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Table(name = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String nameDishes;

    @Column(name = "quantity")
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeItem sizeItem;

    @Column(name = "price")
    private double price;

    //связь с клиентом @ManyToOne
    // связь с кафе

    //список заказанного меню
}
