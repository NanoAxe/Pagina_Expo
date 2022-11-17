package com.spring.boot.api.rest.service;

import java.util.List;

import com.spring.boot.api.rest.entity.Perfiles;

public interface IPerfilService {
	public List<Perfiles> getPerfiles();
	public Perfiles getPerfil(Integer id);
	public Perfiles savePerfil(Perfiles perfil);
	public void deletePerfil(Integer id);
}
