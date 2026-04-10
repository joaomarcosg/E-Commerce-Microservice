package com.joao.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "CPF is required")
    private String cpf;
    private String address;
    @NotBlank(message = "Email is required")
    private String email;
    private String phone;
    private LocalDateTime registrationDate;
}
