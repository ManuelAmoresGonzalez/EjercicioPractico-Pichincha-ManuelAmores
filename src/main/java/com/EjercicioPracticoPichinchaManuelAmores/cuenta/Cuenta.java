package com.EjercicioPracticoPichinchaManuelAmores.cuenta;

import com.EjercicioPracticoPichinchaManuelAmores.cliente.Cliente;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuentaId;


    @Column(length = 50,nullable = false)
    private String tipoCuenta;


    private BigDecimal saldoInicial;

    @Column(length = 50,nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    public Cuenta() {
    }

    public Cuenta(String tipoCuenta, BigDecimal saldoInicial, String estado, Cliente cliente) {
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.cliente = cliente;
    }
}