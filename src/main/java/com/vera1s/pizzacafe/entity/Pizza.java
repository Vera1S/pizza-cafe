package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.entity.enums.NamePizzaEnum;
import com.vera1s.pizzacafe.entity.enums.SizeItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

//Название пиццы согласно ингридиентам

@Entity
@Table(name = "pizza")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name_pizza")
    private NamePizzaEnum namePizzaEnum;

    @ManyToMany
    @JoinTable(
            name = "pizza_ingredients",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredients> ingredientsList;

    @ElementCollection(targetClass = IngredientsForPizza.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "ingredients_for_pizza")
    private Set<IngredientsForPizza> ingredientsForPizza;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeItem sizeItem;

    @ManyToOne
    @JoinColumn(name = "menu_cafe_id")
    private MenuCafe menuCafe;

   }
