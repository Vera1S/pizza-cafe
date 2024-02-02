package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.SizeItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "price")
    private double price;

    @ManyToOne
    private Customer customers;

    @ManyToOne
    private Cafe cafe;

    //список заказанного меню
    @OneToMany(mappedBy = "order")
    private List<BasketItem> basketItem;

    @OneToOne
    private Delivery deliveries;
}
// дата создания заказа
//общую стоимость метод в сервисе
//