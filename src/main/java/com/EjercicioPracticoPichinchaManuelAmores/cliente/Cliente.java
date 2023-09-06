package com.EjercicioPracticoPichinchaManuelAmores.cliente;

import com.EjercicioPracticoPichinchaManuelAmores.cuenta.Cuenta;
import com.EjercicioPracticoPichinchaManuelAmores.persona.Persona;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Cliente extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    private String contrasena;
    private String estado;


    public Cliente() {
        super();
    }

    public Cliente(String nombre,
                   String genero,
                   int edad,
                   String identificacion,
                   String direccion,
                   String telefono,
                   String contrasena,
                   String estado) {
        super();
        this.contrasena = contrasena;
        this.estado = estado;
    }
}
