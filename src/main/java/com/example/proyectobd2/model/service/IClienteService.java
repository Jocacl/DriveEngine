package com.example.proyectobd2.model.service;

import java.util.List;

import com.example.proyectobd2.model.entidad.Cliente;

public interface IClienteService {
    public String guardarCliente(Cliente cliente);
    public List<Cliente> cargarCliente();
    public Cliente buscarCliente(Long id);
    public String eliminarCliente(Long id);
}
