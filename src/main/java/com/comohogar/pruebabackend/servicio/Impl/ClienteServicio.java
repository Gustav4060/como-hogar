package com.comohogar.pruebabackend.servicio.Impl;

import com.comohogar.pruebabackend.dto.ClienteRespuestaDto;
import com.comohogar.pruebabackend.entidad.Cliente;
import com.comohogar.pruebabackend.excepciones.MovimientosException;
import com.comohogar.pruebabackend.repository.IClienteRepository;
import com.comohogar.pruebabackend.restriccion.GrupoEnum;
import com.comohogar.pruebabackend.servicio.IBeneficioServicio;
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

    @Autowired
    private IBeneficioServicio iBeneficioServicio;

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

    @Override
    public ClienteRespuestaDto registrarValida(ClienteRespuestaDto c) throws MovimientosException {
        Boolean validaDescuento=false;
        Cliente cliente= new Cliente();
        cliente.setNombre(c.getNombre());
        cliente.setEmail(c.getEmail());
        cliente.setTelefono(c.getTelefono());
        cliente.setTienda(c.getTienda());
        if (c.getGrupo().equals(GrupoEnum.SK)) {
             validaDescuento= iBeneficioServicio
                    .listar()
                    .stream()
                    .anyMatch (b-> c.getIdDescuento().equals(b.getId()) && b.getGrupoEnum().equals(GrupoEnum.SK));
            cliente.setGrupo(GrupoEnum.SK);
            cliente.setIdDescuento(c.getIdDescuento());
        }
        if (c.getGrupo().equals(GrupoEnum.TH)) {
             validaDescuento= iBeneficioServicio
                    .listar()
                    .stream()
                    .anyMatch(b-> c.getIdDescuento().equals(b.getId()) && b.getGrupoEnum().equals(GrupoEnum.TH));
            cliente.setGrupo(GrupoEnum.SK);
            cliente.setIdDescuento(c.getIdDescuento());
        }
        if (validaDescuento) {
            c.setMensaje("usuario se ha registrado correctamente");
        } else {
            c.setMensaje("no tiene beneficios disponibles");
        }
        repository.save(cliente);
        return c;
    }

}
