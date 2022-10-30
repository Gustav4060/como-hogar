package com.comohogar.pruebabackend.job;

import com.comohogar.pruebabackend.dto.BeneficioDto;
import com.comohogar.pruebabackend.entidad.Beneficios;
import com.comohogar.pruebabackend.excepciones.MovimientosException;
import com.comohogar.pruebabackend.restriccion.GrupoEnum;
import com.comohogar.pruebabackend.servicio.IBeneficioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoggingItemWriter implements ItemWriter<BeneficioDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingItemWriter.class);

    @Autowired
    private IBeneficioServicio iBeneficioServicio;
    @Override
    public void write(List<? extends BeneficioDto> list) throws Exception {
        List<String> beneficios = list.get(0).getBeneficio();
        beneficios.stream().forEach(be->{
                Beneficios beneficio= new Beneficios();
                beneficio.setGrupoEnum(GrupoEnum.TH);
                beneficio.setBeneficio(be);
            try {
                iBeneficioServicio.registrar(beneficio);
            } catch (MovimientosException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
