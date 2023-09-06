package com.EjercicioPracticoPichinchaManuelAmores.movimientos;

import com.EjercicioPracticoPichinchaManuelAmores.cuenta.Cuenta;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;



@Entity
@Data
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movimientoId;

    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    @Column(length = 15,nullable = false)
    private String tipoMovimiento;

    private BigDecimal valor;

    private BigDecimal saldo;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(LocalDate fecha, String tipoMovimiento, BigDecimal valor, BigDecimal saldo, Cuenta cuenta) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

}
