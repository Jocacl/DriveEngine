package com.example.proyectobd2.model.service;

import java.util.List;

import com.example.proyectobd2.model.entidad.Proovedor;

public interface IProovedorService {
    public String guardarProovedor(Proovedor proovedor);
    public List<Proovedor> cargarProovedor();
    public String eliminarProovedor(int id);
}
