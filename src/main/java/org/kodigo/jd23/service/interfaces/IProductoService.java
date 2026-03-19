package org.kodigo.jd23.service.interfaces;

import org.kodigo.jd23.dto.request.ProductoRequestDto;
import org.kodigo.jd23.dto.response.ProductoResponseDto;

import java.util.List;

public interface IProductoService {

    List<ProductoResponseDto> listarTodos();

    ProductoResponseDto obtenerPorId(Long id);

    ProductoResponseDto crear(ProductoRequestDto request);

    ProductoResponseDto actualizar(Long id, ProductoRequestDto request);

    void eliminar(Long id);
}
