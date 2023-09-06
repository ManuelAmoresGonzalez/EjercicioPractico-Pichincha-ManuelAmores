package com.EjercicioPracticoPichinchaManuelAmores.movimientos;

import com.EjercicioPracticoPichinchaManuelAmores.cuenta.Cuenta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class MovimientoTest {

    @Autowired
    private IMovimientoRepository movimientoRepository;

    /*@Test
    public void firstTest(){
        LocalDate date = LocalDate.now();
        Movimiento movimiento = new Movimiento(date, "debito", new BigDecimal(150), new BigDecimal(200));
        Movimiento creado = movimientoRepository.save(movimiento);
        assertThat(creado.getMovimientoId()).isGreaterThan(0);
    }*/
}