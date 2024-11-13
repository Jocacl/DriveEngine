package com.example.proyectobd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectobd2.model.entidad.Cliente;
import com.example.proyectobd2.model.service.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;

    @RequestMapping("/")
    public String inicio(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente",cliente);
        model.addAttribute("listaClientes",clienteService.cargarCliente());
        return "cliente/inicio";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Cliente cliente , RedirectAttributes redirectAttributes){
        String mensaje = clienteService.guardarCliente(cliente);
        redirectAttributes.addFlashAttribute("mensaje",mensaje);
        return "redirect:/cliente/";
    }
    
    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable Long id,Model model){
        Cliente cliente = clienteService.buscarCliente(id);
        model.addAttribute("cliente", cliente);
        return "cliente/editar";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id,RedirectAttributes redirectAttributes){
        String eliminar= clienteService.eliminarCliente(id);
        redirectAttributes.addFlashAttribute("eliminar",eliminar);
        return "redirect:/cliente/";
    }
}
