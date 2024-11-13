package com.example.proyectobd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectobd2.model.entidad.Empleado;
import com.example.proyectobd2.model.service.IEmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    
    @Autowired
    private IEmpleadoService empleadoService;

    @RequestMapping("/")
    public String inicio(Model model){
        Empleado empleado = new Empleado();
        model.addAttribute("empleado",empleado);
        model.addAttribute("listaEmpleados",empleadoService.cargarEmpleados());
        return "empleado/inicio";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Empleado empleado , RedirectAttributes redirectAttributes){
        String mensaje= empleadoService.guardarEmpleado(empleado);
        redirectAttributes.addFlashAttribute("mensaje",mensaje);
        return "redirect:/empleado/";
    }
    
    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable Long id , Model model){
        Empleado empleado=empleadoService.buscarEmpleado(id);
        model.addAttribute("empleado",empleado);
        return "empleado/editar";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id,RedirectAttributes redirectAttributes){
        String eliminar= empleadoService.eliminarEmpleado(id);
        redirectAttributes.addFlashAttribute("eliminar",eliminar);
        return "redirect:/empleado/";
    }    
}
