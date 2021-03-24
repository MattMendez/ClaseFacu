package com.example.demo.repositorys;

import com.example.demo.entitys.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

    List<Email> findAllByUserId(Integer id);
}
