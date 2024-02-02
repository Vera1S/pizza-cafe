package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ingredients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {

    @Id
    @Column(name = "id")
    private Integer id;


    @Enumerated(EnumType.STRING)
    @Column(name = "ingredients_name")
    private IngredientsForPizza name;


}
