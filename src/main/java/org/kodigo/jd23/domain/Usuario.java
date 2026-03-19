package org.kodigo.jd23.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @Column()
    private int edad;

   @OneToMany(mappedBy = "usuario")


   private List<Producto> producto = new ArrayList<>();

    public Usuario(
            @NotBlank(message = "El nombre es obligatorio")
            String nombre,

            @NotBlank(message = "El email es obligatorio")
            @Email(message = "El email debe tener un formato validoo")
            String email) {
        this.nombre= nombre;
        this.email = email;
    }

    public Usuario(
            Long id,
            @NotBlank(message = "El nombre es obligatorio")
            String nombre,
            @NotBlank(message = "El email es obligatorio")
            @Email(message = "El email debe tener un formato validoo")
            String email) {
        this.idUsuario = id;
        this.nombre =  nombre;
        this.email = email;
    }
}
