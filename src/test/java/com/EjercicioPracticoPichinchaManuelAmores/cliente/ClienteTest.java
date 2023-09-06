package com.EjercicioPracticoPichinchaManuelAmores.cliente;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ClienteTest {

    @Autowired
    private IClienteRepository clienteRepository;

    @Test
    public void firtstest(){
        Cliente newCLiente = new Cliente("Manuel","MAsculino",32,"123","San Carlos","6349","12345","Activo");
        Cliente creado = clienteRepository.save(newCLiente);
       // assertThat(creado.getClienteId()).isGreaterThan(0);

    }

}