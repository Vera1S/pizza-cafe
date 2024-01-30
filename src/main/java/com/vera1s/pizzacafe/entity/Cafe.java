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

@Entity
@Table(name = "cafe_pizza")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cafe {

    @Id
    @Column(name = "id")
    private Integer id;


    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "time_status")
    private Time status;
}
