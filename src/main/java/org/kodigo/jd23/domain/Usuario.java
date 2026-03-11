package org.kodigo.jd23.domain;

import jakarta.persistence.*;
import lombok.*;

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
    private Long id;

    @Column(nullable = false, unique = true,length = 255)
    private String nombre;

    @Column(nullable = false, unique = true,length = 255)
    private String email;

}
