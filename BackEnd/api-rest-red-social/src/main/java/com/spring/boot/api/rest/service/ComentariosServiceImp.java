package com.spring.boot.api.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.api.rest.entity.Comentarios;
import com.spring.boot.api.rest.models.dao.IComentarioDao;

@Service
public class ComentariosServiceImp implements IComentariosService{

	@Autowired
	private IComentarioDao comentarioDao;
	@Override
	public List<Comentarios> getComentarios() {
		return (List<Comentarios>) comentarioDao.findAll();
	}
	@Override
	public Comentarios getComentarioId(Integer id) {
		return comentarioDao.findById(id).orElse(null);
	}
	@Override
	public Comentarios saveComentario(Comentarios coment) {
		return comentarioDao.save(coment);
	}
	@Override
	public void deleteComentario(Integer id) {
		comentarioDao.deleteById(id);
	}

}
