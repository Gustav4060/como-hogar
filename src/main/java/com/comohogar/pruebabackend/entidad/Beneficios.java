package com.comohogar.pruebabackend.entidad;

import com.comohogar.pruebabackend.restriccion.GrupoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
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
    public GrupoEnum grupoEnum;
    @OneToMany
    public List<Formato> formatos;
}
