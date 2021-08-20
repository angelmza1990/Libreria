
package com.egg.libreria1.servicios;

import com.egg.libreria1.entidades.Cliente;
import com.egg.libreria1.entidades.Libro;
import com.egg.libreria1.entidades.Prestamo;
import com.egg.libreria1.repositories.PrestamoRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestamoServicio {
    @Autowired
    private PrestamoRepository prestamoRepository;
    
    
    public void pedidoLibro(Libro libro, Cliente cliente){
        Prestamo prestamo = new Prestamo();
        prestamo.setCliente(cliente);
        prestamo.setLibro(libro);
        prestamo.setFecha(new Date());
        
        prestamoRepository.save(prestamo);
    }
    
    public void devolucionLibro(Prestamo prestamo){
        prestamo.setDevolucion(new Date());
        prestamoRepository.save(prestamo);
    }
    
    public Prestamo save(String id, Date fecha, Date devolucion, Double multa){
        Prestamo prestamo = new Prestamo();
        prestamo.setId(id);
        prestamo.setFecha(fecha);
        prestamo.setDevolucion(devolucion);
        prestamo.setMulta(multa);
        return prestamoRepository.save(prestamo);
    }
    
    public List<Prestamo> listAll() {
        return prestamoRepository.findAll();
    }
}
