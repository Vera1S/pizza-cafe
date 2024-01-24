package com.vera1s.pizzacafe.entity;

import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingridients_name")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngridientsName {

    @Id
    @Column(name = "id")
    private Integer id;


    @Column(name = "ingridients_name")
    private IngredientsForPizza ingridientsName;

}
