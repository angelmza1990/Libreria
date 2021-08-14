/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.libreria1.controladores;

import com.egg.libreria1.servicios.PrestamoServicio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/prestamo")
public class PrestamoController {
    @Autowired
    private PrestamoServicio prestamoServicio;
    
    @GetMapping("/list")
    public String listarPrestamos(Model model){
        model.addAttribute("prestamos", prestamoServicio.listAll());
        return "prestamo-list";
    }
    
    @GetMapping("/form")
    public String crearPrestamo(){
        return "prestamo-form";
    }
    
    @PostMapping("/save")
    public String guardarPrestamo(@RequestParam String id, @RequestParam Date fecha, @RequestParam Date devolucion, @RequestParam Double multa){
        prestamoServicio.save(id, fecha, devolucion, multa);
        return "redirect:/prestamo/list";
    }
}
