package com.example.proyectobd2.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.proyectobd2.model.entidad.Empleado;

public interface IEmpleadoDAO extends CrudRepository<Empleado,Long>{
    
}
