
package com.egg.libreria1.controladores;

import com.egg.libreria1.servicios.EditorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editorial")
public class EditorialController {
    
    
    @Autowired
    private EditorialServicio editorialServicio;
    
    @GetMapping("/list")
    public String listarEditoriales(Model model){
        model.addAttribute("editoriales", editorialServicio.listAll());
        return "editorial-list";
    }
    
    @GetMapping("/form")
    public String crearEditorial(){
        return "editorial-form";
    }
    
    @PostMapping("/save")
    public String guardarEditorial(@RequestParam String id, @RequestParam String nombre){
        editorialServicio.save(id, nombre);
        return "redirect:/editorial/list";
    }
    
    
}
