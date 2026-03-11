package org.kodigo.jd23.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Hibernate
 */
@Entity
@Table(name = "usuarios")

/**
 * Lombok
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, unique = true,length = 255)
    private String nombre;

    @Column(nullable = false, unique = true,length = 255)
    private String email;

    @Column(nullable = false, unique = true)
    private int edad;

    @OneToMany(mappedBy = "usuario")
    private List<Producto> producto = new ArrayList<>();
}
