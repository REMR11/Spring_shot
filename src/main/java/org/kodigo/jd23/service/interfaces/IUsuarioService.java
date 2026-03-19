package org.kodigo.jd23.service.interfaces;

import org.kodigo.jd23.dto.request.UsuarioPatchRequestDto;
import org.kodigo.jd23.dto.request.UsuarioRequestDto;
import org.kodigo.jd23.dto.response.ProductoResponseDto;
import org.kodigo.jd23.dto.response.UsuarioConProductosResponseDto;
import org.kodigo.jd23.dto.response.UsuarioResponseDto;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioResponseDto> listarTodos();

    UsuarioResponseDto obtenerPorId(Long id);

    UsuarioResponseDto crear(UsuarioRequestDto request);

    UsuarioResponseDto actualizar(Long id, UsuarioRequestDto requestDto);

    UsuarioResponseDto actualizarParcial(Long id, UsuarioPatchRequestDto request);

    void eliminar(Long id);

    List<UsuarioResponseDto> buscarPorNombre(String nombre);

    UsuarioResponseDto buscarPorEmail(String email);

    List<ProductoResponseDto> listarProductosPorUsuario(Long usuarioId);

    UsuarioConProductosResponseDto obtenerUsuarioConProductos(Long usuarioId);
}
