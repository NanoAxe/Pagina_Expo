package com.spring.boot.api.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.api.rest.entity.Perfiles;
import com.spring.boot.api.rest.models.dao.IPerfilDao;

@Service
public class PerfilesServiceImp implements IPerfilService{

	@Autowired
	private IPerfilDao perfilDao;
	@Override
	public List<Perfiles> getPerfiles() {
		return (List<Perfiles>) perfilDao.findAll();
	}
	@Override
	public Perfiles getPerfil(Integer id) {
		return perfilDao.findById(id).orElse(null);
	}
	@Override
	public Perfiles savePerfil(Perfiles perfil) {
		return perfilDao.save(perfil);
	}
	@Override
	public void deletePerfil(Integer id) {
		perfilDao.deleteById(id);
	}
	
}
