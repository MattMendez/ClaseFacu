package com.example.demo.services;

import com.example.demo.dto.Countries;
import com.example.demo.dto.CountriesName;
import com.example.demo.dto.UserWithEmails;
import com.example.demo.entitys.User;
import com.example.demo.repositorys.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;

    EmailService emailService;


    private RestTemplate restTemplate;


    public List<String> findCountrys(){

        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("https://restcountries.eu/rest/v2/all", Object[].class);

        Object[] objects = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();

        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, CountriesName.class))
                .map(CountriesName::getName)
                .collect(Collectors.toList());

    }

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
