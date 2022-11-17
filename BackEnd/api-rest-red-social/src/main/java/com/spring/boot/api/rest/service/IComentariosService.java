package com.spring.boot.api.rest.service;

import java.util.List;

import com.spring.boot.api.rest.entity.Comentarios;

public interface IComentariosService {
	public List<Comentarios> getComentarios();
	public Comentarios getComentarioId(Integer id);
	public Comentarios saveComentario(Comentarios coment);
	public void deleteComentario(Integer id);
}
