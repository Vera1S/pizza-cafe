package com.vera1s.pizzacafe.service.interfaces;

import com.vera1s.pizzacafe.entity.BasketItem;
import com.vera1s.pizzacafe.entity.SecurityAccount;

import java.util.List;

public interface SecurityAccountService {

    SecurityAccount getById (Integer id);

    List<SecurityAccount> getAllSecurityAccount();

    void save(SecurityAccount securityAccount);

    void deleteById(Integer id);

    void update(Integer id, SecurityAccount securityAccount);


}
