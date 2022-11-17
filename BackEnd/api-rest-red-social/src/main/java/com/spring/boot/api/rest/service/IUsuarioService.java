package com.spring.boot.api.rest.service;

import java.util.List;
import com.spring.boot.api.rest.entity.Usuarios;

public interface IUsuarioService {
	public List<Usuarios> getUsuarios();
	public Usuarios getUsuarioId(Integer id);
	public Usuarios saveUsuario(Usuarios usuario);
	public void deleteUsuario(Integer id);
}
