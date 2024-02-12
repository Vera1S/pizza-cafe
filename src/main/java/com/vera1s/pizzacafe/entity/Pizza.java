package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.SizeItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Название пиццы согласно ингридиентам

@Entity
@Table(name = "pizza")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_pizza")
    private String namePizza;

    @ManyToMany
    private List<Ingredients> ingredients;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeItem sizeItem;

    @ManyToOne
    private MenuItem menuItem;

   }
