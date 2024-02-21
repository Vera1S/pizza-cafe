package com.vera1s.pizzacafe.controller;


import com.vera1s.pizzacafe.dto.SecurityAccountDTO;
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
    public SecurityAccountDTO getAccountById(@PathVariable(value = "id")Integer id){
        SecurityAccount securityAccount = securityAccountService.getById(id);
        SecurityAccountDTO securityAccountDTO = new SecurityAccountDTO(securityAccount.getId(),
                securityAccount.getLogin(), securityAccount.getPassword(), securityAccount.getRole());
        return securityAccountDTO;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<SecurityAccountDTO>> getAllAccount() {
        List<SecurityAccount> securityAccounts = securityAccountService.getAllSecurityAccount();
        List<SecurityAccountDTO> securityAccountDTOS = securityAccounts.stream()
                .map(securityAccount -> new SecurityAccountDTO(securityAccount.getId(), securityAccount.getLogin(),
                        securityAccount.getPassword(), securityAccount.getRole()))
                .toList();
        return ResponseEntity.ok(securityAccountDTOS);
    }
    @PostMapping(value = "/save")
    public void saveAccount(@RequestBody SecurityAccount securityAccount){
        securityAccountService.save(securityAccount);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id")Integer id){
        securityAccountService.deleteById(id);
    }
    @PutMapping(value = "/update/{id}")
    public void updateAccountById(@PathVariable(value = "id")Integer id, @RequestBody SecurityAccount securityAccount){
        securityAccountService.update(id, securityAccount);
    }
}
