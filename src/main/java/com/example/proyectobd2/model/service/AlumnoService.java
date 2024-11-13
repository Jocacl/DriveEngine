package com.example.proyectobd2.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectobd2.model.dao.IAlumnoDAO;
import com.example.proyectobd2.model.entidad.Alumno;

@Service
public class AlumnoService implements IAlumnoService{

    @Autowired
    private IAlumnoDAO alumnoDAO;

    @Override
    public String guardarAlumno(Alumno alumno) {
        try {
            alumnoDAO.save(alumno);
            return "Se registro correctamente el alumno";
        } catch (Exception e) {
            return "Error al registar el alumno"+e.getMessage();
        }
    }

    @Override
    public List<Alumno> cargarAlumnos() {
        return (List<Alumno>)alumnoDAO.findAll();
    }

    @Override
    public String eliminarAlumno(int id) {
       String rpta = "";
       try {
            alumnoDAO.deleteById(id);
            rpta="Se elimino el alumno correctamente";
       } catch (Exception e) {
            rpta=e.getMessage();
       }
       return rpta;
    }
    
}
