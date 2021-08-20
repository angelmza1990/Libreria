
package com.egg.libreria1.servicios;

import com.egg.libreria1.entidades.Autor;
import com.egg.libreria1.entidades.Libro;
import com.egg.libreria1.errores.ErrorServicio;
import com.egg.libreria1.repositories.LibroRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio {
    
    
    @Autowired
    private LibroRepository libroRepository;
    
    @Autowired
    private AutorServicio autorServicio;
    
    
    //public void agregarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer prestados, Libro libro, Editorial editorial){
        
    //}
    @Transactional
     public Libro save(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer prestados){
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setPrestados(prestados);
        return libroRepository.save(libro);
    }
    
    @Transactional 
    public Libro save (Libro libro) throws ErrorServicio{
         if (libro.getTitulo()== null || libro.getTitulo().isEmpty()){
             throw new ErrorServicio("El título del libro no puede ser nulo");
         }
         if (libro.getEditorial() == null){
             throw new ErrorServicio("El libro tiene que tener editorial");
         }
         
         if(libro.getAutor() == null){
             throw new ErrorServicio("El libro tiene que tener un autor");
         }else{
             libro.setAutor(autorServicio.findById(libro.getAutor()));
         }
         
         return libroRepository.save(libro);
     }
    
    public List<Libro> listAll() {
        return libroRepository.findAll();
    }
    
    public List<Libro> listAllByAutor(String nombreautor) {
        return libroRepository.findAllByAutor(nombreautor);
    }
    
    public Optional<Libro> findById(String id)  {
        return libroRepository.findById(id);
    }
    
    public List<Libro> findAllByQ(String q){
        return libroRepository.findAllByQ("%"+q+"%");
    }
    
    @Transactional
    public Libro save(String titulo){
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        return libroRepository.save(libro);
    }
      
    
    
    @Transactional
    public void delete (Libro libro){
        libroRepository.delete(libro);
    }
    
    
    @Transactional
    public void deleteFieldAutor (Autor autor){
        List<Libro> libros = listAllByAutor(autor.getNombre());
        for (Libro libro : libros){
            libro.setAutor(null);
        }
        
        libroRepository.saveAll(libros);
    }
    
    
    @Transactional
    public void deleteById (String id){
        Optional<Libro> optional = libroRepository.findById(id);
        if (optional.isPresent()){
            libroRepository.delete(optional.get());
        }
        
    }
    
    
}
