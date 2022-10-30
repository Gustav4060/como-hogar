package com.comohogar.pruebabackend.repository;

import com.comohogar.pruebabackend.entidad.Beneficios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBeneficioRepository extends JpaRepository<Beneficios,Long> {
}
