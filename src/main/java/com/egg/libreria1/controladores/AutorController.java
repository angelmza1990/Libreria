package com.egg.libreria1.controladores;

import com.egg.libreria1.entidades.Autor;
import com.egg.libreria1.servicios.AutorServicio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorServicio autorServicio;

    @GetMapping("/list")
    public String listarAutores(Model model, @RequestParam(required = false) String q) {
        if (q != null) {
            model.addAttribute("autores", autorServicio.listAllByQ(q));
        } else {
            model.addAttribute("autores", autorServicio.listAll());
        }

        return "autor-list";
    }

    @GetMapping("/form")
    public String crearAutor(Model model, @RequestParam(required = false) String id) {
        if (id != null) {
            Optional<Autor> optional = autorServicio.findById(id);
            if (optional.isPresent()) {
                model.addAttribute("autor", optional.get());
            } else {
                return "redirect:/autor/list";
            }
        } else {
            model.addAttribute("autor", new Autor());
        }
        return "autor-form";
    }

    @PostMapping("/save")
    public String guardarAutor(Model model, RedirectAttributes redirectAttributes, @ModelAttribute Autor autor) {
        try {
            autorServicio.save(autor);
            redirectAttributes.addFlashAttribute("success", "Autor guardado con éxito");
        } catch (Exception e) {
            //model.addAttribute("error", e.getMessage()); 
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/autor/list";
    }

    @GetMapping("/delete")
    public String eliminarAutor(@RequestParam(required = true) String id) {
        autorServicio.deleteById(id);
        return "redirect:/autor/list";
    }

}
