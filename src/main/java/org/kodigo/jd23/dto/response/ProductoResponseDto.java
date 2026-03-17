package org.kodigo.jd23.dto.response;

public record ProductoResponseDto(
        Long id,
        String nombre,
        Double precio,
        Integer stock,
        Long usuarioId,
        String usuarioNombre
) {}
