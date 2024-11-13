package com.example.proyectobd2.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.proyectobd2.model.entidad.Alumno;

public interface IAlumnoDAO  extends CrudRepository<Alumno,Integer>{
    
}
