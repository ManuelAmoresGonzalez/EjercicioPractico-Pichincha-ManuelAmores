package com.EjercicioPracticoPichinchaManuelAmores.services.movimientoservice;

import com.EjercicioPracticoPichinchaManuelAmores.cuenta.Cuenta;
import com.EjercicioPracticoPichinchaManuelAmores.movimientos.IMovimientoRepository;
import com.EjercicioPracticoPichinchaManuelAmores.movimientos.Movimiento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovimientoService {

    private final IMovimientoRepository movimientoRepository;

    public MovimientoService(IMovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    public ArrayList<Movimiento> getMovimientos(){
        return (ArrayList<Movimiento>) movimientoRepository.findAll();
    }

    public Movimiento crearMovimiento(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }

    public Optional<Movimiento> getById(Long id){
        return movimientoRepository.findById(id);
    }

    public Movimiento updateById(Movimiento request, Long id){
        Movimiento movimiento = movimientoRepository.findById(id).get();
        movimiento.setTipoMovimiento(request.getTipoMovimiento());
        movimiento.setFecha(request.getFecha());
        movimiento.setSaldo(request.getSaldo());
        movimiento.setValor(request.getValor());
        movimientoRepository.save(movimiento);
        return movimiento;
    }

    public Boolean eliminarCuenta(Long id){
        try{
            movimientoRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
