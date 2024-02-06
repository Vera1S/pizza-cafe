package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.entity.SecurityAccount;
import com.vera1s.pizzacafe.service.interfaces.SecurityAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/securityAccount")
public class SecurityAccountController {

    private final SecurityAccountService securityAccountService;

    @GetMapping(value = "/id")
    public SecurityAccount getAccountById(@PathVariable(value = "id")Integer id){
        SecurityAccount securityAccount = securityAccountService.getById(id);
        return securityAccount;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<SecurityAccount>> getAllAccount() {
        List<SecurityAccount> securityAccounts = securityAccountService.getAllSecurityAccount();
        return ResponseEntity.ok(securityAccounts);
    }
    @PostMapping(value = "/save")
    public void saveAccount(@RequestBody SecurityAccount securityAccount){
        securityAccountService.save(securityAccount);
    }
    @DeleteMapping(value = "/delete")
    public void deleteById(@PathVariable(value = "id")Integer id){
        securityAccountService.deleteById(id);
    }
    @PutMapping(value = "/update")
    public void updateAccountById(@PathVariable(value = "id")Integer id, @RequestBody SecurityAccount securityAccount){
        securityAccountService.update(id, securityAccount);
    }
}
