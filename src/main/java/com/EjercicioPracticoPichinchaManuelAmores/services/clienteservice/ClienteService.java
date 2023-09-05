package com.EjercicioPracticoPichinchaManuelAmores.services.clienteservice;

import com.EjercicioPracticoPichinchaManuelAmores.cliente.Cliente;
import com.EjercicioPracticoPichinchaManuelAmores.cliente.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClienteService {


    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ArrayList<Cliente> getClientes(){
        return (ArrayList<Cliente>) clienteRepository.findAll();
    }

    public Cliente crearCliente(Cliente user){
        return clienteRepository.save(user);
    }

    public Optional<Cliente> getById(Long id){
        return clienteRepository.findById(id);
    }

    public Cliente updateById(Cliente request, Long id){
        Cliente cliente = clienteRepository.findById(id).get();
        cliente.setNombre(request.getNombre());
        clienteRepository.save(cliente);
        return cliente;
    }

    public Boolean eliminarCliente(Long id){
        try{
            clienteRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
