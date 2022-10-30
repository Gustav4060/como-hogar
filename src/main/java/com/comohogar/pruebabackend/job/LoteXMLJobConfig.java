package com.comohogar.pruebabackend.job;

import com.comohogar.pruebabackend.dto.BeneficioDto;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class LoteXMLJobConfig {

    @Bean
    public ItemReader<BeneficioDto> itemReader() {
        Jaxb2Marshaller beneficioMarshaller = new Jaxb2Marshaller();
        beneficioMarshaller.setClassesToBeBound(BeneficioDto.class);

        return new StaxEventItemReaderBuilder<BeneficioDto>()
                .name("beneficiosReader")
                .resource(new ClassPathResource("data/th_formato.xml"))
                .addFragmentRootElements("beneficios")
                .unmarshaller(beneficioMarshaller)
                .build();
    }
    @Bean
    public ItemWriter<BeneficioDto> itemWriter() {
        return new LoggingItemWriter();
    }

    @Bean
    public Step exampleJobStep(ItemReader<BeneficioDto> reader,
                               ItemWriter<BeneficioDto> writer,
                               StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("beneficioJobStep")
                .<BeneficioDto, BeneficioDto>chunk(1)
                .reader(reader)
                .writer(writer)
                .build();
    }

 
    @Bean
    public Job exampleJob(Step exampleJobStep,
                          JobBuilderFactory jobBuilderFactory) {
        return jobBuilderFactory.get("beneficioJob")
                .incrementer(new RunIdIncrementer())
                .flow(exampleJobStep)
                .end()
                .build();
    }
}
