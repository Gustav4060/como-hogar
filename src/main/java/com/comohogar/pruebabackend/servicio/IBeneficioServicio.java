package com.comohogar.pruebabackend.servicio;

import com.comohogar.pruebabackend.entidad.Beneficios;
import com.comohogar.pruebabackend.excepciones.MovimientosException;

import java.util.List;

public interface IBeneficioServicio {

    Beneficios registrar(Beneficios c) throws MovimientosException;

    Beneficios modificar(Beneficios c) throws MovimientosException;

    List<Beneficios> listar() throws MovimientosException;

    Beneficios listarPorId(Long id) throws MovimientosException;

    void eliminar(Long id) throws MovimientosException;
}
