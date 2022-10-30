package com.comohogar.pruebabackend.servicio;

import com.comohogar.pruebabackend.excepciones.MovimientosException;
import com.comohogar.pruebabackend.entidad.Cliente;

import java.util.List;

public interface IClienteServicio {

    Cliente registrar(Cliente c) throws MovimientosException;

    Cliente modificar(Cliente c) throws MovimientosException;

    List<Cliente> listar() throws MovimientosException;

    Cliente listarPorId(Long id) throws MovimientosException;

    void eliminar(Long id) throws MovimientosException;

    
}
