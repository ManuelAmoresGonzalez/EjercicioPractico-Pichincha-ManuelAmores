/*package com.EjercicioPracticoPichinchaManuelAmores.movimientos;

import com.EjercicioPracticoPichinchaManuelAmores.cuenta.Cuenta;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;



@Entity
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movimientoId;


    private Date fecha;

    private String tipoMovimiento;


    private BigDecimal valor;


    private BigDecimal saldo;

    @ManyToOne
    @JoinColumn(name = "numero_cuenta")
    private Cuenta cuenta;

    // Getters y setters
}*/
