package com.comohogar.pruebabackend.dto;

import com.comohogar.pruebabackend.restriccion.GrupoEnum;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ClienteDto {


    private long id;


    @NotNull(message = "Nombre no puede ser nulo")
    @Schema(description = "nombres del cliente")
    @Size(min = 3, message = "{nombres.size}")
    private String nombre;

    @NotNull(message = "Nombre no puede ser nulo")
    private String email;

    @NotNull
    @Size(min = 10, max = 10, message = "Telefono debe tener 10 caracteres")
    private String telefono;

    @NotNull(message = "Nombre no puede ser nulo")
    private String tienda;

    @NotNull(message = "Nombre no puede ser nulo")
    private GrupoEnum grupo;
}
