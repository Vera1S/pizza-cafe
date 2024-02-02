package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CustomerStatus status;

    @OneToMany(mappedBy = "customers")
    private List<Order> orders;

    @OneToMany(mappedBy = "customers")
    private List<BasketItem> basketItem;

    @OneToMany(mappedBy = "customers")
    private List<Delivery> deliveries;

}
