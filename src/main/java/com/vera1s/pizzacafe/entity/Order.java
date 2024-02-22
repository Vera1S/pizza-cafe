package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.SizeItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price")
    private double price;

    @ManyToOne
    private Customer customers;

    @ManyToOne
    private Cafe cafe;

    @OneToMany(mappedBy = "order")
    private Collection<BasketItem> basketItem;

    @OneToOne(mappedBy = "order")
    private Delivery deliveries;

    public Order(double price, Customer customers) {
        this.price = price;
        this.customers = customers;
    }
}

