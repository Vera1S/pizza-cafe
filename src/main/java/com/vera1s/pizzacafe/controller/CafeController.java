package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.dto.CafeDTO;
import com.vera1s.pizzacafe.entity.Cafe;
import com.vera1s.pizzacafe.service.interfaces.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
public class CafeController {

    private final CafeService cafeService;

    @GetMapping(value = "/id")
    public CafeDTO getCafeById(@PathVariable(value = "id")Integer id){
        Cafe cafe = cafeService.getById(id);
        CafeDTO cafeDTO = new CafeDTO(cafe.getId(), cafe.getName(), cafe.getEmail(), cafe.getAddress(),
                cafe.getPhone(), cafe.getStatus());
        return cafeDTO;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CafeDTO>> getAllCafe() {
        List<Cafe> cafe = cafeService.getAllCafe();
        List<CafeDTO> cafeDTOS = cafe.stream()
                .map(c -> new CafeDTO(c.getId(), c.getName(), c.getEmail(), c.getAddress(),
                        c.getPhone(), c.getStatus()))
                .toList();
        return ResponseEntity.ok(cafeDTOS);
    }
    @PostMapping(value = "/save")
    public void saveCafe(@RequestBody Cafe cafe){
        cafeService.save(cafe);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id")Integer id){
        cafeService.deleteById(id);
    }
    @PutMapping(value = "/update/{id}")
    public void updateCafeById(@PathVariable(value = "id")Integer id, @RequestBody Cafe cafe){
        cafeService.update(id, cafe);
    }
}
