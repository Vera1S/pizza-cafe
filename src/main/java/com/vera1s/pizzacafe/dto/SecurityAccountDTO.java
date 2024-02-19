package com.vera1s.pizzacafe.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SecurityAccountDTO {

    private Integer id;


    private String login;


    private String password;


    private String role;
}
