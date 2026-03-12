package org.kodigo.jd23.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductoRequestDto(
    @NotBlank
    String nombre,

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "EL precio debe ser mayor que cero o igual a cero")
    Double precio,

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "EL stock debe ser mayor que cero o igual a cero")
    Integer stock,

    @NotNull(message = "El usuarioId es obligatorio")
    Long usuarioId
) {}
