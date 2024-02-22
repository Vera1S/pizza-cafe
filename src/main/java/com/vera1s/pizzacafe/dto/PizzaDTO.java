package com.vera1s.pizzacafe.dto;

import com.vera1s.pizzacafe.entity.Ingredients;

import com.vera1s.pizzacafe.entity.enums.NamePizza;
import com.vera1s.pizzacafe.entity.enums.SizeItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaDTO {

    private Integer id;

    private String namePizza;


    private SizeItem sizeItem;

    private List<Ingredients> ingredients;

}
