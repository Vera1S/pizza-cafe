package com.vera1s.pizzacafe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Название пиццы согласно ингридиентам

@Entity
@Table(name = "namePizza")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NamePizza {

    @Id
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "namePizza")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "ingredientsForPizza")
    private IngredientsForPizza ingredients;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeEntity size;


}
