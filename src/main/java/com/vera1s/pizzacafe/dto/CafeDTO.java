package com.vera1s.pizzacafe.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

/**
 * Класс CafeDTO создан для заказа еды,
 * этот класс поможет хранить и передавать информацию о кафе.
 *
 * Когда пользователь (регистрируется) в приложении или оформляет заказ, данные
 *  * о кафе (название, адрес, контактная информация) могут быть представлены через
 *  * объекты CafeDTO
 *
 * Класс помогает структурировать данные и обеспечивает модульность кода.
 */
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
