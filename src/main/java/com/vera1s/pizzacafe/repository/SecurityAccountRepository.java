package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.SecurityAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityAccountRepository extends CrudRepository<SecurityAccount, Integer> {

    SecurityAccount findByLogin(String login);


}
