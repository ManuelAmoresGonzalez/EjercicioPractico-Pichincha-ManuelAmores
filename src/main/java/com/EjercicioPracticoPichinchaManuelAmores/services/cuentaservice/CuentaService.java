package com.EjercicioPracticoPichinchaManuelAmores.services.cuentaservice;

import com.EjercicioPracticoPichinchaManuelAmores.cuenta.Cuenta;
import com.EjercicioPracticoPichinchaManuelAmores.cuenta.ICuentaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CuentaService {

    private final ICuentaRepository cuentaRepository;

    public CuentaService(ICuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public ArrayList<Cuenta> getCuentas(){
        return (ArrayList<Cuenta>) cuentaRepository.findAll();
    }

    public Cuenta crearCuenta(Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> getById(Long id){
        return cuentaRepository.findById(id);
    }

    public void updateById(Cuenta request, Long id){
        Cuenta cuenta = cuentaRepository.findById(id).get();
        cuenta.setTipoCuenta(request.getTipoCuenta());
        cuenta.setSaldoInicial(request.getSaldoInicial());
        cuenta.setEstado(request.getEstado());
        cuentaRepository.save(cuenta);
    }

    public Boolean eliminarCuenta(Long id){
        try{
            cuentaRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
