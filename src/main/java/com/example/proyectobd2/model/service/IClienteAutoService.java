package com.example.proyectobd2.model.service;

import java.util.List;

import com.example.proyectobd2.model.entidad.ClienteAuto;

public interface IClienteAutoService {
    public String guardarAuto(ClienteAuto auto);
    public List<ClienteAuto> cargarAutos();
    public String eliminarAuto(int id);
}
