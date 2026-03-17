package org.kodigo.jd23.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.kodigo.jd23.domain.Producto;
import org.kodigo.jd23.domain.Usuario;
import org.kodigo.jd23.dto.request.ProductoRequestDto;
import org.kodigo.jd23.dto.response.ProductoResponseDto;
import org.kodigo.jd23.repository.ProductoRepository;
import org.kodigo.jd23.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepository repository;
    private final UsuarioRepository usuarioRepository;

    public ProductoService(ProductoRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }


    public List<ProductoResponseDto>listarTodos(){
        return repository.findAll().stream().map(this::toResponseDto).toList();
    }

    public ProductoResponseDto obtenerPorId(Long id){
        Producto producto = repository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Producto con id: "+id+" no encontrado"));
        return toResponseDto(producto);
    }

    public ProductoResponseDto crear(ProductoRequestDto request){
        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Usuario con id" + request.usuarioId() + " No encontrado"
                ));

        Producto producto  = new Producto(
                null,
                request.nombre(),
                request.precio(),
                request.stock(),
                usuario);

        return toResponseDto(producto);
    }



    // Serealizar
    private ProductoResponseDto toResponseDto(Producto producto) {
        return new ProductoResponseDto(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getUsuario().getIdUsuario(),
                producto.getUsuario().getNombre()
        );
    }

}
