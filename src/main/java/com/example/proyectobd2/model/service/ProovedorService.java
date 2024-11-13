package com.example.proyectobd2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.proyectobd2.model.dao.IProovedorDAO;
import com.example.proyectobd2.model.entidad.Proovedor;

@Service
public class ProovedorService implements IProovedorService{

    @Autowired
    private IProovedorDAO proovedorDAO;

    @Override
    public String guardarProovedor(Proovedor proovedor) {
        try {
            proovedorDAO.save(proovedor);
            return "Se registro correctamente el proovedor";
        } catch (Exception e) {
            return "Error al registar el proovedor "+e.getMessage();
        }
    }

    @Override
    public List<Proovedor> cargarProovedor() {
        return (List<Proovedor>)proovedorDAO.findAll();
    }

    @Override
    public String eliminarProovedor(int id) {
        String rpta = "";
       try {
            proovedorDAO.deleteById(id);
            rpta="Se elimino el registro correctamente";
       } catch (Exception e) {
            rpta=e.getMessage();
       }
       return rpta;
    }
    
}
