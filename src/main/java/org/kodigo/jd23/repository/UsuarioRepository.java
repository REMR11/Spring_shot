package org.kodigo.jd23.repository;

import org.kodigo.jd23.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u FROM usuario u LEFT JOIN FETCH u.productos WHERE u.id = :id")
    Optional<Usuario> findByIdWithProductos(@Param("id") Long id);
}
