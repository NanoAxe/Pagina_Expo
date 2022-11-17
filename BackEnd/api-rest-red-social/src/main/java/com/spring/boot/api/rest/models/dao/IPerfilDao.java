package com.spring.boot.api.rest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.api.rest.entity.Perfiles;

public interface IPerfilDao extends CrudRepository<Perfiles, Integer>{

}
