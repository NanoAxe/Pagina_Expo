package com.spring.boot.api.rest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.api.rest.entity.Comentarios;

public interface IComentarioDao extends CrudRepository<Comentarios, Integer>{

}
