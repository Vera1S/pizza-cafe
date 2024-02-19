package com.vera1s.pizzacafe.dto;

import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientsDTO {

    private Integer id;

    private IngredientsForPizza name;


}
