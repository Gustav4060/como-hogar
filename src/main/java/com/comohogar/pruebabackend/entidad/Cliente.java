package com.comohogar.pruebabackend.entidad;

import com.comohogar.pruebabackend.restriccion.GrupoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefono", nullable = false ,length = 10)
    private String telefono;

    @Column(name = "tienda", nullable = false ,length = 100)
    private String tienda;

    @Column(name = "grupo", nullable = false ,length = 2)
    @Enumerated(EnumType.STRING)
    private GrupoEnum grupo;

    @Column(name = "idDescuento", nullable = false ,length = 100)
    private Long idDescuento;

}
