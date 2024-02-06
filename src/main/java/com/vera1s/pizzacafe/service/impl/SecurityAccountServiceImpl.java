package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.SecurityAccount;
import com.vera1s.pizzacafe.repository.SecurityAccountRepository;
import com.vera1s.pizzacafe.service.SecurityAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SecurityAccountServiceImpl implements SecurityAccountService {

    private final SecurityAccountRepository securityAccountRepository;
    @Override
    public SecurityAccount getById(Integer id) {
        return null;
    }

    @Override
    public List<SecurityAccount> getAllSecurityAccount() {
        return null;
    }

    @Override
    public void save(SecurityAccount securityAccount) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Integer id, SecurityAccount securityAccount) {

    }
}
