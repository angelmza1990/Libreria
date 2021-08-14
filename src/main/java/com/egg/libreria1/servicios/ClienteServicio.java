
package com.egg.libreria1.servicios;

import com.egg.libreria1.entidades.Cliente;
import com.egg.libreria1.repositories.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    
    public Cliente save(Long documento, String nombre, String apellido, String domicilio, String telefono){
        Cliente cliente = new Cliente();
        cliente.setDocumento(documento);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDomicilio(domicilio);
        cliente.setTelefono(telefono);
        return clienteRepository.save(cliente);
    }
    
    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }
}
