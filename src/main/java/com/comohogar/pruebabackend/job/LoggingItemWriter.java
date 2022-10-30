package com.comohogar.pruebabackend.job;

import com.comohogar.pruebabackend.dto.BeneficioDto;
import com.comohogar.pruebabackend.dto.RootJDto;
import com.comohogar.pruebabackend.entidad.Beneficios;
import com.comohogar.pruebabackend.excepciones.MovimientosException;
import com.comohogar.pruebabackend.restriccion.GrupoEnum;
import com.comohogar.pruebabackend.servicio.IBeneficioServicio;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LoggingItemWriter implements ItemWriter<BeneficioDto> {

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
        loadFileJson();
    }

    private void loadFileJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        RootJDto fileJson = mapper.readValue(new File("src/main/resources/data/sk_formato.json"), RootJDto.class);
        fileJson.sk_formato.stream().forEach(be->{
            Beneficios beneficio= new Beneficios();
            beneficio.setGrupoEnum(GrupoEnum.SK);
            beneficio.setBeneficio(be.getBeneficio());
            try {
                iBeneficioServicio.registrar(beneficio);
            } catch (MovimientosException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
