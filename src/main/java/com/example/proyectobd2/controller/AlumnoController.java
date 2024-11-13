package com.example.proyectobd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectobd2.model.entidad.Alumno;
import com.example.proyectobd2.model.service.IAlumnoService;
import com.example.proyectobd2.model.service.ICarreraService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private ICarreraService carreraService;

    @Autowired
    private IAlumnoService alumnoService;
    
    @RequestMapping("/")
    public String inicio(Model model){
        Alumno alumno = new Alumno();

        model.addAttribute("alumno", alumno);
        model.addAttribute("listaCarreras",carreraService.cargarCarrerasOrdenadas());//ordena las carreras de forma asc
        model.addAttribute("listaAlumnos", alumnoService.cargarAlumnos());
        //model.addAttribute("listaCarreras",carreraService.cargarCarrerasFiltro("%ing%")); Mostrar las carreras con el filtro like solo muestra las carreras ing
        return "alumno/inicio";
    }

    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    public String guardar(Alumno alumno,RedirectAttributes redirectAttributes){
        String mensaje=alumnoService.guardarAlumno(alumno);
        redirectAttributes.addFlashAttribute("mensaje",mensaje);
        return "redirect:/alumno/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, RedirectAttributes redirectAttributes){
        String mensaje= alumnoService.eliminarAlumno(id);
        redirectAttributes.addFlashAttribute("mensaje", mensaje);
        return "redirect:/alumno/";
    }
}
