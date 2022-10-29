package com.comohogar.pruebabackend.repository;

import com.comohogar.pruebabackend.entidad.Cliente;
import com.comohogar.pruebabackend.restriccion.GrupoEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest {
    @Autowired
    private IClienteRepository IClienteRepository;

    @Test
    public void whenFindingCustomerById_thenCorrect() {
        IClienteRepository.save(new Cliente(1L, "John", "john@domain.com", "0981539347", " la plaza", GrupoEnum.SK));
        assertThat(IClienteRepository.findById(1L)).isInstanceOf(Optional.class);
    }

    @Test
    public void whenFindingAllCustomers_thenCorrect() {
        IClienteRepository.save(new Cliente(1L,"John", "john@domain.com","0981539347", " la plaza", GrupoEnum.SK ));
        IClienteRepository.save(new Cliente(2L,"Julie", "julie@domain.com","0981539347", " la plaza", GrupoEnum.TH));
        assertThat(IClienteRepository.findAll()).isInstanceOf(List.class);
    }

    @Test
    public void whenSavingCustomer_thenCorrect() {
        IClienteRepository.save(new Cliente(1L,"Bob", "bob@domain.com","0981539347", " la plaza", GrupoEnum.SK));
        Cliente cliente = IClienteRepository.findById(1L).orElseGet(()
                -> new Cliente(1L,"Bob", "bob@domain.com","0981539347", " la plaza", GrupoEnum.SK));
        assertThat(cliente.getNombre().equals("Bob"));
    }
}
