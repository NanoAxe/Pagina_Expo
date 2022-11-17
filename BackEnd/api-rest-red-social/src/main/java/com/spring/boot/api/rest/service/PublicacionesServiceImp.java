package com.spring.boot.api.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.api.rest.entity.Publicaciones;
import com.spring.boot.api.rest.models.dao.IPublicacionDao;

@Service
public class PublicacionesServiceImp implements IPublicacionesService{

	@Autowired
	public IPublicacionDao publicacionDao;
	
	@Override
	public List<Publicaciones> getPublicaciones() {
		return (List<Publicaciones>) publicacionDao.findAll();
	}
	
	@Override
	public Publicaciones getPublId(Integer id) {
		return publicacionDao.findById(id).orElse(null);
	}
	
	@Override
	public Publicaciones savePubl(Publicaciones publ) {
		return publicacionDao.save(publ);
	}
	
	@Override
	public void deletePubli(Integer id) {
		publicacionDao.deleteById(id);
	}

}
