package com.vera1s.pizzacafe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

}
