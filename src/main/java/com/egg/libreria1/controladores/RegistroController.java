/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.libreria1.controladores;

import com.egg.libreria1.errores.ErrorServicio;
import com.egg.libreria1.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registro")
public class RegistroController {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("")
    public String registro(){
        return "registro";
    }
    
    @PostMapping("")
    public String registroSave (Model model, @RequestParam String username, @RequestParam String password,@RequestParam String password2){
        try{
            usuarioServicio.save(username, password, password2);
            return "redirect:/";
        }catch(ErrorServicio ex){
            model.addAttribute("error", ex.getMessage());
            model.addAttribute("username", username);
            return "registro";
        }
    }
    
}
