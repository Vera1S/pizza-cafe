package com.vera1s.pizzacafe.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class CafeDTO {

    private Integer id;

    private String name;

    private String email;


    private String address;


    private String phone;


    private LocalTime status;
}
