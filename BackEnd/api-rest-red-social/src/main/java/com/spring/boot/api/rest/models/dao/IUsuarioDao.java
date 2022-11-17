package com.spring.boot.api.rest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.api.rest.entity.Usuarios;

public interface IUsuarioDao extends CrudRepository<Usuarios, Integer>{

}
