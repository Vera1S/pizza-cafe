package com.vera1s.pizzacafe.service.impl;

import com.vera1s.pizzacafe.entity.Customer;
import com.vera1s.pizzacafe.entity.SecurityAccount;
import com.vera1s.pizzacafe.repository.SecurityAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SecurityAccountServiceImplTest {

    @Mock
    private SecurityAccountRepository securityAccountRepository;

    @InjectMocks
    private SecurityAccountServiceImpl securityAccountServiceImpl;

    private List<SecurityAccount> securityAccounts;

    @BeforeEach
    void setUp() {
        // Создаем список пицц
        securityAccounts = new ArrayList<>();
        List<Customer> customers = List.of();

        // Добавляем несколько экземпляров пицц в список
        securityAccounts.add(new SecurityAccount());
        //1, "fdkf", "address", "password", "ADMIN", customers
    }

    @Test
    void getAllSecurityAccount() {

        // Задаем поведение мокито для метода findAll()
        when(securityAccountRepository.findAll()).thenReturn(securityAccounts);

        // Запускаем тестируемый метод
        List<SecurityAccount> returnedSecurityAccount = securityAccountServiceImpl.getAllSecurityAccount();

        // Проверяем результаты теста
        assertNotNull(returnedSecurityAccount);
        assertEquals(1, returnedSecurityAccount.size());

        SecurityAccount returnedSecurityAccountElement = returnedSecurityAccount.get(0);
       // assertEquals(1, returnedSecurityAccountElement.getId());
        assertEquals(null, returnedSecurityAccountElement.getLogin());

    }
}