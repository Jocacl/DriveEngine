package com.example.proyectobd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectobd2.model.entidad.Carrera;
import com.example.proyectobd2.model.service.ICarreraService;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    private ICarreraService carreraService;
    
    @RequestMapping("/")
    public String inicio(Model model){
        Carrera carrera = new Carrera();
        model.addAttribute("carrera", carrera);
        model.addAttribute("listaCarreras",carreraService.cargarCarreras());
        return "carrera/inicio";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Carrera carrera , RedirectAttributes redirectAttributes){
        String mensaje = carreraService.guardarCarrera(carrera);
        redirectAttributes.addFlashAttribute("mensaje",mensaje);
        return "redirect:/carrera/";
    }

    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable Long id ,Model model){
        Carrera carrera = carreraService.buscarCarrera(id);
        model.addAttribute("carrera",carrera);
        return "carrera/editar";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes){
        String eliminar = carreraService.eliminarCarrera(id);
        redirectAttributes.addFlashAttribute("eliminar",eliminar);
        return  "redirect:/carrera/";
    }
}
