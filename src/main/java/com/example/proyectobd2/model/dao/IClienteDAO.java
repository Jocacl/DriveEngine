package com.example.proyectobd2.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.proyectobd2.model.entidad.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente,Long>{
    
}
