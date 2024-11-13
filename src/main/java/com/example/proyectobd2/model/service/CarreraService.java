package com.example.proyectobd2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectobd2.model.dao.ICarreraDAO;
import com.example.proyectobd2.model.entidad.Carrera;

import jakarta.transaction.Transactional;

@Service
public class CarreraService implements ICarreraService {

    @Autowired
    private ICarreraDAO carreraDAO;

    @Override
    @Transactional
    public String guardarCarrera(Carrera carrera) {
        try {
            String mensaje="";
            if (carrera.getId()==null) {
                mensaje="Se Registro correctamente la carrera "+carrera.getNombre();
            }else{
                mensaje="Se actualizo correctamente la carrera "+carrera.getNombre();
            }
            carreraDAO.save(carrera);
            return mensaje;
        } catch (Exception e) {
            return "Error al guardar"+e.getMessage();
        }        
    }

    @Override
    public List<Carrera> cargarCarreras() {
       return (List<Carrera>)carreraDAO.findAll();
    }

    @Override
    public Carrera buscarCarrera(Long id) {
        return carreraDAO.findById(id).get();
    }

    @Override
    public String eliminarCarrera(Long id) {
        try {
            carreraDAO.deleteById(id);
            return "Carrera eliminada correctamente";
        } catch (Exception e) {
            return "Error al eliminar la carrera"+e.getMessage();
        }
    }

    @Override
    public List<Carrera> cargarCarrerasOrdenadas() {
       return carreraDAO.findAllByOrderByNombreAsc();
    }

    @Override
    public List<Carrera> cargarCarrerasFiltro(String param) {
        return carreraDAO.joca(param);
    }
}
