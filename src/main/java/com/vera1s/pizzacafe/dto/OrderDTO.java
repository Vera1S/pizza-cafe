package com.vera1s.pizzacafe.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDTO {

    private Integer id;


    private double price;
}
