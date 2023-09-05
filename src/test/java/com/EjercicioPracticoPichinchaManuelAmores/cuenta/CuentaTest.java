package com.EjercicioPracticoPichinchaManuelAmores.cuenta;

import com.EjercicioPracticoPichinchaManuelAmores.cliente.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class CuentaTest {

    @Autowired
    private ICuentaRepository cuentaRepository;

    @Test
    public void firtstest(){
        Cuenta newCuenta = new Cuenta("Ahorro", new BigDecimal(10000), "Activa");
        Cuenta creado = cuentaRepository.save(newCuenta);
        assertThat(creado.getCuentaId()).isGreaterThan(0);
    }
}