package com.vera1s.pizzacafe.controller;

import com.vera1s.pizzacafe.dto.PizzaDTO;
import com.vera1s.pizzacafe.entity.Pizza;
import com.vera1s.pizzacafe.service.interfaces.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PizzaDTOController { //переименовать класс и добавить методы админа

    private final PizzaService pizzaService;

//        @GetMapping("/name")
//    public ResponseEntity<List<PizzaDTO>> getAllPizzas() {
//        List<Pizza> pizzas = pizzaService.getAllPizzas();
//
//        List<PizzaDTO> pizzaDTOs = pizzas.stream()
//                //stream() и map(this::convertToDTO) это Используются для преобразования каждой сущности Pizza в соответствующий DTO.
//                //convertToDTO(Pizza pizza) это Приватный метод, который преобразует сущность Pizza в DTO.
//             //   .map(this::convertToDTO)
//                //Создает успешный HTTP-ответ (200 OK) и возвращает список DTO пицц в теле ответа.
//                .collect(Collectors.toList());
//
//        //ResponseEntity.ok(pizzaDTOs): Создает успешный HTTP-ответ (200 OK) и возвращает список DTO пицц в теле ответа.
//        return ResponseEntity.ok(pizzaDTOs);
//    }

//        private PizzaDTO convertToDTO(Pizza pizza) {
//        return new PizzaDTO(pizza.getNamePizza(), pizza.getSizeItem(), null);
//    }

}
