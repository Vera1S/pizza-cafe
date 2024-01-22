package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.entity.enums.NamePizzaEnum;
import com.vera1s.pizzacafe.entity.enums.SizeItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Название пиццы согласно ингридиентам

@Entity
@Table(name = "pizza")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    @Id
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name_pizza")
    private NamePizzaEnum namePizzaEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "ingredients_for_pizza")
    private IngredientsForPizza ingredients;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeItem sizeItem;


}
