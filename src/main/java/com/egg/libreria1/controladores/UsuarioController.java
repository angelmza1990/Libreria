
package com.egg.libreria1.controladores;

import com.egg.libreria1.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/usuario")
public class UsuarioController {
    
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
     @GetMapping("/list")
    public String listarUsuarios(Model model, @RequestParam(required = false) String q) {
        if (q != null) {
            model.addAttribute("usuarios", usuarioServicio.listAllByQ(q));
        } else {
            model.addAttribute("usuarios", usuarioServicio.listAll());
        }

        return "usuario-list";
    }
    
}
