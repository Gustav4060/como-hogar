package com.comohogar.pruebabackend.dto;

import com.comohogar.pruebabackend.restriccion.GrupoEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class ClienteRespuestaDto {
    private long id;

    @NotNull(message = "Nombre no puede ser nulo")
    @Schema(description = "nombres del cliente")
    private String nombre;

    @NotNull(message = "Nombre no puede ser nulo")
    private String email;

    @NotNull
    @Size(min = 10, max = 10, message = "Telefono debe tener 10 caracteres")
    private String telefono;

    private String tienda;

    @NotNull(message = "Nombre no puede ser nulo")
    private GrupoEnum grupo;

    private String mensaje;

    private Long idDescuento;
}
