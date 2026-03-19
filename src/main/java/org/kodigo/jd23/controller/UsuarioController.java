package org.kodigo.jd23.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.kodigo.jd23.dto.request.UsuarioRequestDto;
import org.kodigo.jd23.dto.response.UsuarioResponseDto;
import org.kodigo.jd23.exception.ErrorResponse;
import org.kodigo.jd23.service.interfaces.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final IUsuarioService service;

    public UsuarioController(IUsuarioService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos los usuarios")
    @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenidos")
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>>  listarTodos(){

        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(summary = "Obtener usuario por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> obtenerPorId(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(service.obtenerPorId(id));
    }


    @Operation(summary = "Crear un nuevo usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuario creado"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada invalidos",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PostMapping
    public ResponseEntity<UsuarioResponseDto> crear (
            @Valid @RequestBody UsuarioRequestDto request){
        UsuarioResponseDto created = service.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


    @Operation(summary = "Actualizar un usuario existente", description = "Endpoint que actualiza")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada no validos",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequestDto request
    ){
        return  ResponseEntity.ok(service.actualizar(id, request));
    }


    @Operation(summary = "Eliminar un usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Usuario eliminado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
