/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.libreria1.servicios;

import com.egg.libreria1.entidades.Editorial;
import com.egg.libreria1.repositories.EditorialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicio {
    @Autowired
    private EditorialRepository editorialRepository;
    
    
    public Editorial save(String id, String nombre){
        Editorial editorial = new Editorial();
        editorial.setId(id);
        editorial.setNombre(nombre);
        
        return editorialRepository.save(editorial);
    }
    
    public List<Editorial> listAll() {
        return editorialRepository.findAll();
    }
}
