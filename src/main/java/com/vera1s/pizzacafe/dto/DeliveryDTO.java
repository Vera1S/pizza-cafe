package com.vera1s.pizzacafe.dto;

import com.vera1s.pizzacafe.entity.enums.DriverStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс DeliveryDTO предназначен для представления данных о доставке, таких как
 * идентификатор доставки, статус водителя и адрес доставки.
 * Он используется для передачи этих данных между классами данного приложения и
 * при использовании REST API.
 */
@Data
@AllArgsConstructor
public class DeliveryDTO {

    private Integer id;

    private DriverStatus driverStatus;

    private String address;
}
