package com.comohogar.pruebabackend.entidad;

import com.comohogar.pruebabackend.restriccion.GrupoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "beneficios")
public class Beneficios {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    private GrupoEnum grupoEnum;
    private String beneficio;
}
