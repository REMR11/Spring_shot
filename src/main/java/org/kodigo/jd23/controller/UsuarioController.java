package org.kodigo.jd23.controller;

import org.kodigo.jd23.domain.Usuario;
import org.kodigo.jd23.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<Usuario> getUser(
            @RequestParam String nombre
    ){
        return repository.findByNombreContainingIgnoreCase(nombre);
    }
//
//    @GetMapping
//    public Optional<Usuario> getUserByEmail(
//            @RequestParam String email
//    ){
//        return repository.findByEmail(email).orElseThrow(new Exception("Uusario no encontrado"));
//    }

}
