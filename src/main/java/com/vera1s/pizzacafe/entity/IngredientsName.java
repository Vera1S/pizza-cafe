package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ingredients_name")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsName {

    @Id
    @Column(name = "ingredients_id")
    private Integer id;


    @Column(name = "ingredients_name")
    private IngredientsForPizza ingredientsName;

    @ManyToMany(mappedBy = "ingredients")
    private List<Pizza> pizza;

}
