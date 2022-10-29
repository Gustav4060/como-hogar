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
@Table(name = "formato")
public class Formato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String beneficio;

}
