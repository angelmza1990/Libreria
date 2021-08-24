/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.libreria1.servicios;

import com.egg.libreria1.entidades.Usuario;
import com.egg.libreria1.errores.ErrorServicio;
import com.egg.libreria1.repositories.UsuarioRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Transactional
    public Usuario save(String username, String password, String password2) throws ErrorServicio{
        Usuario usuario = new Usuario();
        
        if(username.isEmpty() || username == null){
            throw new ErrorServicio("el nombre de usuario no puede ser nulo");
        }
        if( password == null  || password2 == null || password.isEmpty() || password2.isEmpty()){
            throw new ErrorServicio("el password no puede ser vacio");
        }
        
        if(!password.equals(password2)){
            throw new ErrorServicio("Las contraseñas deben ser iguales");
        }
        
        usuario.setUsername(username);
        usuario.setPassword(password);
        
        return usuarioRepository.save(usuario);
    }
    
    public Usuario findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }
    
    
    public List<Usuario> listAll() {
        return usuarioRepository.findAll();
    }
    
    public List<Usuario> listAllByQ(String q) {
        return usuarioRepository.findAll();
        //return usuarioRepository.findAllByQ("%"+q+"%");
    }
    
}
