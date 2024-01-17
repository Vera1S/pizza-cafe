package com.vera1s.pizzacafe.service;

import com.vera1s.pizzacafe.entity.SizeItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderService {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String nameDishes;

    @Column(name = "quantity")
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeItem size;

    @Column(name = "price")
    private double price;
}
