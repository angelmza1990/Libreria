
package com.egg.libreria1.servicios;

import com.egg.libreria1.entidades.Autor;
import com.egg.libreria1.errores.ErrorServicio;
import com.egg.libreria1.repositories.AutorRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutorServicio {
    
    
    @Autowired
    private AutorRepository autorRepository;
    
    @Transactional
    public void registrarAutor (String nombre) throws ErrorServicio{
        validarAutor(nombre);
        Autor autor = new Autor();
        autor.setNombre(nombre);
        
        autorRepository.save(autor);
        
    }
    
    @Transactional
    public void modificarAutor (String id, String nombre) throws ErrorServicio {
        validarAutor(nombre);
        
        Optional<Autor> respuesta = autorRepository.findById(id);
        
        if(respuesta.isPresent()){
        Autor autor = respuesta.get();
        autor.setNombre(nombre);
        
        autorRepository.save(autor);
        } else{
            throw new ErrorServicio("No se encontró el autor solicitado");
        }
    }
    
    private void validarAutor(String nombre) throws ErrorServicio{
         if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("El nombre del autor no puede ser nulo");
        }
    }
    
    
    public Optional<Autor> findById(String id)  {
        return autorRepository.findById(id);
    }
    
    @Transactional
    public Autor save(String id, String nombre){
        Autor autor = new Autor();
        autor.setId(id);
        autor.setNombre(nombre);
        return autorRepository.save(autor);
    }
    
    @Transactional
    public Autor save(Autor autor) throws Exception{
        if (autor.getNombre().isEmpty() || autor.getNombre()==null){
            throw new ErrorServicio(" El nombre no puede estar vacion");
        }
        return autorRepository.save(autor);
    }
    
    
    public List<Autor> listAll() {
        return autorRepository.findAll();
    }
    
    public List<Autor> listAllByQ(String q) {
        return autorRepository.findAllByQ("%"+q+"%");
    }
    
   
    
    
    @Transactional
    public void delete (Autor autor){
        autorRepository.delete(autor);
    }
    
    
    @Transactional
    public void deleteById (String id){
        Optional<Autor> optional = autorRepository.findById(id);
        if (optional.isPresent()){
            autorRepository.delete(optional.get());
        }
        
    }
    
    
    
}
