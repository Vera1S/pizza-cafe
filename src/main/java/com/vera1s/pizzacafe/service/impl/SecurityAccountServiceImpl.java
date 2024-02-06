package com.vera1s.pizzacafe.service.impl;


import com.vera1s.pizzacafe.entity.SecurityAccount;
import com.vera1s.pizzacafe.repository.SecurityAccountRepository;
import com.vera1s.pizzacafe.service.interfaces.SecurityAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityAccountServiceImpl implements SecurityAccountService {

    private final SecurityAccountRepository securityAccountRepository;

    @Override
    public SecurityAccount getById(Integer id) {
        Optional<SecurityAccount> optional = securityAccountRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null; //return securityAccountRepository.findById(id).orElse(null);
        }
    }

    @Override
    public List<SecurityAccount> getAllSecurityAccount() {
        return securityAccountRepository.findAll();
    }

    @Override
    public void save(SecurityAccount securityAccount) {
        if (securityAccount == null) {
            return;
        }
        securityAccountRepository.save(securityAccount);
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null && securityAccountRepository.existsById(id)) {
            securityAccountRepository.deleteById(id);
        }
    }

    @Override
    public void update(Integer id, SecurityAccount securityAccount) {
        Optional<SecurityAccount> persistSecurityAccountoptional = securityAccountRepository.findById(id);
        if (persistSecurityAccountoptional.isPresent()) { //если есть
            SecurityAccount persistSecurityAccount = persistSecurityAccountoptional.get(); //покажи
            persistSecurityAccount.setId(securityAccount.getId()); //в старый id устанавливаем новое имя
            //   persistSecurityAccount.getLogin(securityAccount.getLogin());
            persistSecurityAccount.setRole(securityAccount.getRole());
            persistSecurityAccount.setPassword(securityAccount.getPassword());
            // persistSecurityAccount.getUsername(securityAccount.getUsername());
            securityAccountRepository.save(securityAccount); //пересохраняем старые данные
        }
    }
}
