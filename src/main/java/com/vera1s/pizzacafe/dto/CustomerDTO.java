package com.vera1s.pizzacafe.dto;

import com.vera1s.pizzacafe.entity.enums.CustomerStatus;
import com.vera1s.pizzacafe.entity.enums.DriverStatus;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс CustomerDTO служит для хранения и передачи данных о клиентах между
 * различными классами данного приложения.
 *
 * Объекты этого класса используются для передачи информации о клиентах между
 * микросервисами, базами данных, пользовательским интерфейсом и другими
 * компонентами системы.
 */
@Data
@AllArgsConstructor
public class CustomerDTO {

    private Integer id;

    private String name;

    private String email;

    private String address;

    private String phone;

    private CustomerStatus status;
}
