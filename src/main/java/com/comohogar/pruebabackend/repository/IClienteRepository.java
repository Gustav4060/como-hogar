package com.comohogar.pruebabackend.repository;

import com.comohogar.pruebabackend.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
