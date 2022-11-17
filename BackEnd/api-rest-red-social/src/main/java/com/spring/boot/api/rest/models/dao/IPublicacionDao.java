package com.spring.boot.api.rest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.api.rest.entity.Publicaciones;

public interface IPublicacionDao extends CrudRepository<Publicaciones, Integer>{

}
