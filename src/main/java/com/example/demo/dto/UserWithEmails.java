package com.example.demo.dto;

import com.example.demo.entitys.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserWithEmails {

    private Integer idUser;

    private String nombre;

    private String apellido;

    private List<Email> emailList;
}
