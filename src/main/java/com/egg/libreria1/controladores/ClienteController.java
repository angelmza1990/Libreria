
package com.egg.libreria1.controladores;

import com.egg.libreria1.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {
    
    @Autowired
    private ClienteServicio clienteServicio;
    
    @GetMapping("/list")
    public String listarClientes(Model model){
        model.addAttribute("clientes", clienteServicio.listAll());
        return "cliente-list";
    }
    
    @GetMapping("/form")
    public String crearCliente(){
        return "cliente-form";
    }
    
    @PostMapping("/save")
    public String guardarCliente(@RequestParam Long documento, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String domicilio, @RequestParam String telefono){
        clienteServicio.save(documento, nombre, apellido, domicilio, telefono);
        return "redirect:/cliente/list";
    }
    
}
