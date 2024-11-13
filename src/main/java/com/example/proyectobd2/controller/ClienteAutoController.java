package com.example.proyectobd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectobd2.model.entidad.ClienteAuto;
import com.example.proyectobd2.model.service.IClienteAutoService;
import com.example.proyectobd2.model.service.IClienteService;

@Controller
@RequestMapping("/auto")
public class ClienteAutoController {
    
    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IClienteAutoService autoService;

    @RequestMapping("/")
    public String inicio(Model model){
        ClienteAuto auto=new ClienteAuto();
        model.addAttribute("auto",auto);
        model.addAttribute("listaclientes",clienteService.cargarCliente());
        model.addAttribute("listaAutos",autoService.cargarAutos());
        return "vehiculo/inicio";
    }

    @RequestMapping(value = "/guardar",method =  RequestMethod.POST)
    public String guardar(ClienteAuto clienteAuto, RedirectAttributes redirectAttributes){
        String mensaje=autoService.guardarAuto(clienteAuto);
        redirectAttributes.addFlashAttribute("mensaje",mensaje);
        return "redirect:/auto/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id,RedirectAttributes redirectAttributes){
        String mensaje=autoService.eliminarAuto(id);
        redirectAttributes.addFlashAttribute("mensaje",mensaje);
        return "redirect:/auto/";
    }
}
