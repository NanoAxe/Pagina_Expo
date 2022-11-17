package com.spring.boot.api.rest.service;

import java.util.List;

import com.spring.boot.api.rest.entity.Publicaciones;

public interface IPublicacionesService {
	public List<Publicaciones> getPublicaciones();
	public Publicaciones getPublId(Integer id);
	public Publicaciones savePubl(Publicaciones publ);
	public void deletePubli(Integer id);
}
