package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.CustomerStatus;
import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.entity.enums.NamePizzaEnum;
import com.vera1s.pizzacafe.entity.enums.SizeItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "cafe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cafe {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "adress")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "time_status")
    private LocalTime status; //open close two

    @OneToMany(mappedBy = "cafe")
    private List<Order> orders;

    @OneToMany(mappedBy = "cafe")
    private List<Delivery> deliveries;
}
