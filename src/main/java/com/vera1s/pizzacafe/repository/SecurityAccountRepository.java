package com.vera1s.pizzacafe.repository;

import com.vera1s.pizzacafe.entity.SecurityAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityAccountRepository extends JpaRepository<SecurityAccount, Integer> {

    SecurityAccount findByLogin(String login);


    List<SecurityAccount> findAllById(Integer id);

}
