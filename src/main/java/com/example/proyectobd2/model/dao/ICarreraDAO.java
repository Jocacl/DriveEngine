package com.example.proyectobd2.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.proyectobd2.model.entidad.Carrera;

public interface ICarreraDAO extends CrudRepository<Carrera,Long> {
    public List<Carrera> findAllByOrderByNombreAsc();//con metodo

    @Query(value = "SELECT * FROM carreras WHERE car_nombre like ?1",nativeQuery = true)
    public List<Carrera> joca(String param);//con sql
}
