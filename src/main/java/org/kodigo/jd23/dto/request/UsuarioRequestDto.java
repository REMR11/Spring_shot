package org.kodigo.jd23.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDto(
       @NotBlank(message = "El nombre es obligatorio")
       String nombre,

       @NotBlank(message = "El email es obligatorio")
       @Email(message = "El email debe tener un formato validoo")
       String email
) {}
