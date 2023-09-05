package com.EjercicioPracticoPichinchaManuelAmores.cliente;

import com.EjercicioPracticoPichinchaManuelAmores.persona.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository  extends JpaRepository<Cliente, Long> {
}
