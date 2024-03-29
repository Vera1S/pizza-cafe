package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.CustomerStatus;
import com.vera1s.pizzacafe.entity.enums.DriverStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "delivery")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "driver_status")
    private DriverStatus driverStatus;

    @OneToOne
    private Order order;

    @ManyToOne
    private Customer customers;

    @ManyToOne
    private Cafe cafe;
}


