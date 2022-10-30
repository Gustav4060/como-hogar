package com.comohogar.pruebabackend.servicio.Impl;

import com.comohogar.pruebabackend.entidad.Beneficios;
import com.comohogar.pruebabackend.excepciones.MovimientosException;
import com.comohogar.pruebabackend.repository.IBeneficioRepository;
import com.comohogar.pruebabackend.servicio.IBeneficioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BeneficioServicio implements IBeneficioServicio {

    @Autowired
    private IBeneficioRepository repository;

    @Override
    public Beneficios registrar(Beneficios b) throws MovimientosException {
        repository.save(b);
        return b;
    }

    @Override
    public Beneficios modificar(Beneficios b) throws MovimientosException {
        repository.save(b);
        return b;
    }

    @Override
    public List<Beneficios> listar() throws MovimientosException {
        return repository.findAll();
    }

    @Override
    public Beneficios listarPorId(Long id) throws MovimientosException {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) throws MovimientosException {
        repository.deleteById(id);
    }
}
