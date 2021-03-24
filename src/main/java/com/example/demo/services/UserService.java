package com.example.demo.services;

import com.example.demo.dto.UserWithEmails;
import com.example.demo.entitys.User;
import com.example.demo.repositorys.EmailRepository;
import com.example.demo.repositorys.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    EmailService emailService;

    public UserWithEmails algo(Integer id){

        User user = userRepository.findById(id).get();

        UserWithEmails response = UserWithEmails.builder()
                .idUser(user.getId())
                .nombre(user.getNombre())
                .apellido(user.getApellido())
                .emailList(emailService.findEmailsByUserId(id))
                .build();

        return new UserWithEmails();
    }
}
