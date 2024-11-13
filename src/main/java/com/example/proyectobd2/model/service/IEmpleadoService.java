package com.example.proyectobd2.model.service;

import java.util.List;

import com.example.proyectobd2.model.entidad.Empleado;

public interface IEmpleadoService {
    public String guardarEmpleado(Empleado empleado);
    public List<Empleado> cargarEmpleados();
    public Empleado buscarEmpleado(Long id);
    public String eliminarEmpleado(Long id);
}
