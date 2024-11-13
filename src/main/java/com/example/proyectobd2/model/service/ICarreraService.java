package com.example.proyectobd2.model.service;

import java.util.List;

import com.example.proyectobd2.model.entidad.Carrera;

public interface ICarreraService {
    public String guardarCarrera(Carrera carrera);
    public List<Carrera> cargarCarreras();
    public List<Carrera> cargarCarrerasOrdenadas();
    public List<Carrera> cargarCarrerasFiltro(String param);
    public Carrera buscarCarrera(Long id);
    public String eliminarCarrera(Long id);
}
