package com.example.demo.services;

import com.example.demo.entitys.Email;
import com.example.demo.repositorys.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    EmailRepository emailRepository;

    public List<Email> findEmailsByUserId(Integer id){

        return emailRepository.findAllByUserId(id);
    }
}
