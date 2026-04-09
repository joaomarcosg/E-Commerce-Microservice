package com.joao.ecommerce.controller;

import com.joao.ecommerce.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public static List<UserDTO> users = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList() {

        UserDTO userDTO = new UserDTO();
        userDTO.setName("Eduardo");
        userDTO.setCpf("123");
        userDTO.setAddress("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setPhone("1234-3454");
        userDTO.setRegistrationDate(LocalDateTime.now());

        UserDTO userDTO2 = new UserDTO();
        userDTO.setName("Luiz");
        userDTO.setCpf("456");
        userDTO.setAddress("Rua b");
        userDTO.setEmail("luiz@email.com");
        userDTO.setPhone("1234-3454");
        userDTO.setRegistrationDate(LocalDateTime.now());

        UserDTO userDTO3 = new UserDTO();
        userDTO.setName("Bruna");
        userDTO.setCpf("678");
        userDTO.setAddress("Rua c");
        userDTO.setEmail("bruna@email.com");
        userDTO.setPhone("1234-3454");
        userDTO.setRegistrationDate(LocalDateTime.now());

        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);
    }

    @GetMapping("/")
    public String getMessage() {
        return "Spring Boot is working";
    }

    @GetMapping("/{cpf}")
    public UserDTO getUserByCpf(@PathVariable String cpf) {
        return users
                .stream()
                .filter(userDTO -> userDTO.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return users;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        userDTO.setRegistrationDate(LocalDateTime.now());
        users.add(userDTO);
        return userDTO;
    }

}
