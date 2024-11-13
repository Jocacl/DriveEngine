package com.example.proyectobd2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectobd2.model.dao.IEmpleadoDAO;
import com.example.proyectobd2.model.entidad.Empleado;

import jakarta.transaction.Transactional;

@Service
public class EmpleadoService implements IEmpleadoService{

    @Autowired
    private IEmpleadoDAO empleadoDAO;


    @Override
    @Transactional
    public String guardarEmpleado(Empleado empleado) {
        try {
            String mensaje="";
            if (empleado.getId()==null) {
                mensaje="Se Registro correctamente el empleado "+empleado.getNombre();
            }else{
                mensaje="Se actualizo correctamente el empleado "+empleado.getNombre();
            }
            empleadoDAO.save(empleado);
            return mensaje;
        } catch (Exception e) {
            return "Error al guardar"+e.getMessage();
        } 
    }

    @Override
    public List<Empleado> cargarEmpleados() {
        return (List<Empleado>)empleadoDAO.findAll();
    }

    @Override
    public Empleado buscarEmpleado(Long id) {
       return empleadoDAO.findById(id).get();
    }

    @Override
    public String eliminarEmpleado(Long id) {
        try {
            empleadoDAO.deleteById(id);
            return "Empleado eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar el empleado "+e.getMessage();
        }
    }
    
}
