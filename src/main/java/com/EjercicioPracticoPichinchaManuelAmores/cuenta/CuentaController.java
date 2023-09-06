package com.EjercicioPracticoPichinchaManuelAmores.cuenta;

import com.EjercicioPracticoPichinchaManuelAmores.cliente.Cliente;
import com.EjercicioPracticoPichinchaManuelAmores.cliente.IClienteRepository;
import com.EjercicioPracticoPichinchaManuelAmores.services.clienteservice.ClienteService;
import com.EjercicioPracticoPichinchaManuelAmores.services.cuentaservice.CuentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;
    private final IClienteRepository clienteRepository;

    public CuentaController(CuentaService cuentaService, IClienteRepository clienteRepository) {
        this.cuentaService = cuentaService;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public ArrayList<Cuenta> getCuentas() { return cuentaService.getCuentas();}

    @PostMapping
    public ResponseEntity<Object> crearCuenta(@RequestBody Cuenta cuenta){
        Optional<Cliente> cliente = clienteRepository.findById(cuenta.getCliente().getClienteId());
        if(cliente.isEmpty())
           return ResponseEntity.ok(Boolean.FALSE);
        this.cuentaService.crearCuenta(cuenta);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(path= "/{id}")
    public Optional<Cuenta> getById(@PathVariable Long id){
        return this.cuentaService.getById(id);
    }

    @PutMapping(path= "/{id}")
    public ResponseEntity<Object> updateUserById(@RequestBody Cuenta request, @PathVariable("id") Long id){
        this.cuentaService.updateById(request, id);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping(path= "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.cuentaService.eliminarCuenta(id);
        return ok ? "User with id" + id + " deleted!!!" : "Error, we have a problem and can't delete user with id " + id;
    }


}
