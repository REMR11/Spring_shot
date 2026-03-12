package org.kodigo.jd23.dto.response;


public record ProductoResposeDto(
        Long id,
        String nombre,
        Double precio,
        Integer stock,
        Long usuarioId,
        String usuarioNombre
) {
}
