package org.kodigo.jd23.service.implement;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.kodigo.jd23.domain.Producto;
import org.kodigo.jd23.domain.Usuario;
import org.kodigo.jd23.dto.request.ProductoRequestDto;
import org.kodigo.jd23.dto.response.ProductoResponseDto;
import org.kodigo.jd23.repository.ProductoRepository;
import org.kodigo.jd23.repository.UsuarioRepository;
import org.kodigo.jd23.service.interfaces.IProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductoService implements IProductoService {

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

    public ProductoResponseDto actualizar(Long id, ProductoRequestDto request){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Producto con Id: " + id + " No encontrado");
        }

        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow( ()-> new EntityNotFoundException("Usuario con el id "+request.usuarioId() + " no encontrado"));


        Producto updated = new Producto(
                id,
                request.nombre(),
                request.precio(),
                request.stock(),
                usuario
        );
        Producto saved = repository.save(updated);
        return  toResponseDto(saved);
    }

    public void eliminar(Long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Producto con id " + id + " no encontrado");
        }
        repository.deleteById(id);
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
