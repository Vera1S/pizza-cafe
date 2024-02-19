package com.vera1s.pizzacafe.dto;

import com.vera1s.pizzacafe.entity.enums.DriverStatus;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

    private Integer id;


    private DriverStatus driverStatus;
}
