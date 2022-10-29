package com.comohogar.pruebabackend.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name="beneficios")
public class SkFormato {
    public String beneficio;
}
