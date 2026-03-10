package org.kodigo.jd23.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping({"/hello/helloword", "/jd23/hello"})
    public String hello(){
        return "Hello KodiJava!";
    }

    @GetMapping("/hello2/{nombreAlumno}")
    public String hello_2(
            @PathVariable String nombreAlumno
    ){
        return "Hello! " + nombreAlumno;
    }

    @GetMapping("/buscar")
    public String buscar(
           @RequestParam String nombre,
           @RequestParam(defaultValue = "true")boolean activo
    ){
        return "Buscado: "+ nombre + ", estudiante activo: "+ activo;
    }

    @PostMapping("/crear")
    public String crear(
            @RequestBody Map<String, Object> body
            ){
        String nombre = (String) body.get("nombre");
        Object edad =  body.get("edad");
        return "Recibido: "+  nombre + ", edad: "+ edad;
    }
}
