package com.comohogar.pruebabackend.servicio.Impl;

import com.comohogar.pruebabackend.dto.SkFormato;
import com.comohogar.pruebabackend.entidad.Cliente;
import com.comohogar.pruebabackend.excepciones.MovimientosException;
import com.comohogar.pruebabackend.repository.IClienteRepository;
import com.comohogar.pruebabackend.servicio.IClienteServicio;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ClienteServicio implements IClienteServicio {
    @Autowired
    private IClienteRepository repository;
    @Setter
    @Getter
    private List<SkFormato> lstBeneficios;
    @Override
    public Cliente registrar(Cliente c) throws MovimientosException {
        return repository.save(c);
    }

    @Override
    public Cliente modificar(Cliente c) throws MovimientosException {
        return repository.save(c);
    }

    @Override
    public List<Cliente> listar() throws MovimientosException {
        return repository.findAll();
    }

    @Override
    public Cliente listarPorId(Long id) throws MovimientosException {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) throws MovimientosException {
        repository.deleteById(id);
    }


}
