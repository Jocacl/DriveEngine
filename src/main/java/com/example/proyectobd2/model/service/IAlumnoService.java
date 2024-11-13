package com.example.proyectobd2.model.service;

import java.util.List;

import com.example.proyectobd2.model.entidad.Alumno;

public interface IAlumnoService {
    public String guardarAlumno(Alumno alumno);
    public List<Alumno> cargarAlumnos();
    public String eliminarAlumno(int id);
}
