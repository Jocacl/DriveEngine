package com.example.proyectobd2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectobd2.model.dao.IClienteAutoDAO;
import com.example.proyectobd2.model.entidad.ClienteAuto;

@Service
public class ClienteAutoService implements IClienteAutoService{
    
    @Autowired
    private IClienteAutoDAO autoDAO;

    @Override
    public String guardarAuto(ClienteAuto auto) {
        try {
            autoDAO.save(auto);
            return "Se registro correctamente el alumno";
        } catch (Exception e) {
            return "Error al registar el alumno"+e.getMessage();
        }
    }

    @Override
    public List<ClienteAuto> cargarAutos() {
        return (List<ClienteAuto>)autoDAO.findAll();
    }

    @Override
    public String eliminarAuto(int id) {
        String rpta = "";
       try {
            autoDAO.deleteById(id);
            rpta="Se elimino el registro correctamente";
       } catch (Exception e) {
            rpta=e.getMessage();
       }
       return rpta;
    }

}
