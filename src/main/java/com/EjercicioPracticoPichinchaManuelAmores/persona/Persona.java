package com.EjercicioPracticoPichinchaManuelAmores.persona;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class Persona {

    @Column(length = 50,nullable = false)
    private String nombre;
    @Column(length = 15,nullable = false)
    private String genero;
    @Column(name = "edad",nullable = false)
    private int edad;
    @Column(length = 20,nullable = false)
    private String identificacion;
    @Column(length = 255,nullable = false)
    private String direccion;
    @Column(length = 15,nullable = false)
    private String telefono;

    public Persona() {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
