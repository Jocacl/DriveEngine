package com.example.proyectobd2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectobd2.model.dao.IClienteDAO;
import com.example.proyectobd2.model.entidad.Cliente;

import jakarta.transaction.Transactional;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    @Transactional
    public String guardarCliente(Cliente cliente) {
        try {
            String mensaje="";
            if (cliente.getId()==null) {
                mensaje="Se Registro correctamente el cliente "+cliente.getNombres();
            }else{
                mensaje="Se actualizo correctamente el cliente "+cliente.getNombres();
            }
            clienteDAO.save(cliente);
            return mensaje;
        } catch (Exception e) {
            return "Error al guardar"+e.getMessage();
        } 
    }

    @Override
    public List<Cliente> cargarCliente() {
       return (List<Cliente>)clienteDAO.findAll();
    }

    @Override
    public Cliente buscarCliente(Long id) {
        return clienteDAO.findById(id).get();
    }

    @Override
    public String eliminarCliente(Long id) {
        try {
            clienteDAO.deleteById(id);
            return "Cliente eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar el cliente"+e.getMessage();
        }
    }   
}
