package com.vera1s.pizzacafe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "cafe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "time_status")
    private LocalTime status;    //openStatus;

//    @Column(name = "time_status")
//    private LocalTime closeStatus;

    @OneToMany(mappedBy = "cafe")
    private List<Order> orders;

    @OneToMany(mappedBy = "cafe")
    private List<Delivery> deliveries;
}
