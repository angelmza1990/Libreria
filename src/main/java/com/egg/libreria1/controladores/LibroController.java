/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.libreria1.controladores;

import com.egg.libreria1.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libro")
public class LibroController {
    
    
    @Autowired
    private LibroServicio libroServicio;
    
    @GetMapping("/list")
    public String listarLibros(Model model){
        model.addAttribute("libros", libroServicio.listAll());
        return "libro-list";
    }
    
    @GetMapping("/form")
    public String crearLibro(){
        return "libro-form";
    }
    
    @PostMapping("/save")
    public String guardarLibro(@RequestParam Long isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer prestados){
        libroServicio.save(isbn,titulo,anio, ejemplares, prestados);
        return "redirect:/libro/list";
    }
    
}
