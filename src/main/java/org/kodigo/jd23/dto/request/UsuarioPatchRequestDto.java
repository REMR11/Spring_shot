package org.kodigo.jd23.dto.request;

import jakarta.validation.constraints.Email;

public record UsuarioPatchRequestDto(
    String nombre,
    @Email(message = "El email debe tener un formato valido")
    String email
) {}
