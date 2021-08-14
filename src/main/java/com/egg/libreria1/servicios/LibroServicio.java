
package com.egg.libreria1.servicios;

import com.egg.libreria1.entidades.Libro;
import com.egg.libreria1.repositories.LibroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio {
    
    
    @Autowired
    private LibroRepository libroRepository;
    
    
    //public void agregarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer prestados, Autor autor, Editorial editorial){
        
    //}
    
     public Libro save(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer prestados){
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setPrestados(prestados);
        return libroRepository.save(libro);
    }
    
    public List<Libro> listAll() {
        return libroRepository.findAll();
    }
    
}
