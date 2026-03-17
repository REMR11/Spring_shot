package org.kodigo.jd23.dto.response;

import java.util.List;

public record UsuarioConProductosResponseDto(
        Long id,
        String nombre,
        String email,
        List<ProductoResponseDto> productos
        ) {
}
