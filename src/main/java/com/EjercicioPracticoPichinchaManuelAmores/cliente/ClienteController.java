package com.EjercicioPracticoPichinchaManuelAmores.cliente;

import com.EjercicioPracticoPichinchaManuelAmores.services.clienteservice.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ArrayList<Cliente> getClientes() { return clienteService.getClientes();}

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente){
        return this.clienteService.crearCliente(cliente);
    }

    @GetMapping(path= "/{id}")
    public Optional<Cliente> getById(@PathVariable Long id){
        return this.clienteService.getById(id);
    }

    @PutMapping(path= "/{id}")
    public ResponseEntity<Object> updateUserById(@RequestBody Cliente request, @PathVariable("id") Long id){
        System.out.println("************"+request.getNombre());
        this.clienteService.updateById(request, id);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping(path= "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.clienteService.eliminarCliente(id);
        return ok ? "User with id" + id + " deleted!!!" : "Error, we have a problem and can't delete user with id " + id;
    }

}
