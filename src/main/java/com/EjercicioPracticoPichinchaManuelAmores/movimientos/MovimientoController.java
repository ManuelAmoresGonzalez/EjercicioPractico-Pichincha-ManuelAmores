package com.EjercicioPracticoPichinchaManuelAmores.movimientos;

import com.EjercicioPracticoPichinchaManuelAmores.cuenta.Cuenta;
import com.EjercicioPracticoPichinchaManuelAmores.services.movimientoservice.MovimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping
    public ArrayList<Movimiento> getMovimientos() {
        return movimientoService.getMovimientos();}

    @PostMapping
    public Movimiento crearCuenta(@RequestBody Movimiento movimiento){
        return this.movimientoService.crearMovimiento(movimiento);
    }

    @GetMapping(path= "/{id}")
    public Optional<Movimiento> getById(@PathVariable Long id){
        return this.movimientoService.getById(id);
    }

    @PutMapping(path= "/{id}")
    public ResponseEntity<Object> updateUserById(@RequestBody Movimiento request, @PathVariable("id") Long id){
        this.movimientoService.updateById(request, id);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping(path= "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.movimientoService.eliminarCuenta(id);
        return ok ? "User with id" + id + " deleted!!!" : "Error, we have a problem and can't delete user with id " + id;
    }
}
