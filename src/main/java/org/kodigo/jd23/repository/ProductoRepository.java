package org.kodigo.jd23.repository;

import org.kodigo.jd23.domain.Producto;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreCotainingIgnoreCase(String nombre);
    List<Producto> findByUsuarioId(Long usuarioId);



}
