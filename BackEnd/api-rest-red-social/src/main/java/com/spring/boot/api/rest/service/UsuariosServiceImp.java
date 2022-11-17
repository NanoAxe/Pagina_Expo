package com.spring.boot.api.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.api.rest.entity.Usuarios;
import com.spring.boot.api.rest.models.dao.IUsuarioDao;

@Service
public class UsuariosServiceImp implements IUsuarioService{
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> getUsuarios() {
		return (List<Usuarios>) usuarioDao.findAll();
	}

	@Override
	public Usuarios getUsuarioId(Integer id) {
		return usuarioDao.findById(id).orElse(null);
	}
	//sirve tambien para actualizar
	@Override
	public Usuarios saveUsuario(Usuarios usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	public void deleteUsuario(Integer id) {
		usuarioDao.deleteById(id);
	}

}
