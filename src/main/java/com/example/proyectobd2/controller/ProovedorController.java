package com.example.proyectobd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectobd2.model.entidad.Proovedor;
import com.example.proyectobd2.model.service.IProovedorService;

@Controller
@RequestMapping("/proovedor")
public class ProovedorController {
    
    @Autowired
    private IProovedorService proovedorService;

    @RequestMapping("/")
    public String inicio(Model model){
        Proovedor proovedor = new Proovedor();
        model.addAttribute("proovedor",proovedor);
        model.addAttribute("listaProovedor",proovedorService.cargarProovedor());
        return "proovedor/inicio";
    }

    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    public String guardar(Proovedor proovedor,RedirectAttributes redirectAttributes){
        String mensaje=proovedorService.guardarProovedor(proovedor);
        redirectAttributes.addFlashAttribute("mensaje",mensaje);
        return "redirect:/proovedor/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id,RedirectAttributes redirectAttributes){
        String mensaje=proovedorService.eliminarProovedor(id);
        redirectAttributes.addFlashAttribute("mensaje",mensaje);
        return "redirect:/proovedor/";
    }
}
