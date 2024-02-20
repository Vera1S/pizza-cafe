package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.entity.Cafe;
import com.vera1s.pizzacafe.service.interfaces.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
public class CafeController {

    private final CafeService cafeService;

    @GetMapping(value = "/id")
    public Cafe getCafeById(@PathVariable(value = "id")Integer id){
        Cafe cafe = cafeService.getById(id);
        return cafe;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Cafe>> getAllCafe() {
        List<Cafe> cafe = cafeService.getAllCafe();
        return ResponseEntity.ok(cafe);
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
