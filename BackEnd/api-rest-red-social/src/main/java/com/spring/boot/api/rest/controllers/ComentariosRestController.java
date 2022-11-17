package com.spring.boot.api.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.api.rest.entity.Comentarios;
import com.spring.boot.api.rest.service.IComentariosService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ComentariosRestController {
	
	@Autowired
	private IComentariosService comentService;
	
	@GetMapping("/comentarios")
	public List<Comentarios> getComents(){
		return comentService.getComentarios();
	}
	
	@GetMapping("/comentario/:{id}")
	public Comentarios getComentarioId(@PathVariable Integer id) {
		return comentService.getComentarioId(id);
	}
	
	@PostMapping("/comentario")
	@ResponseStatus(HttpStatus.CREATED)
	public Comentarios saveComentario(@RequestBody Comentarios comentario) {
		return comentService.saveComentario(comentario);
	}
	
	@PutMapping("/comentario/:{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Comentarios updateComentario(@RequestBody Comentarios comentario, @PathVariable Integer id) {
		Comentarios comentActual = comentService.getComentarioId(id);
		comentActual.setContenido(comentario.getContenido());
		return comentService.saveComentario(comentActual);
	}
	
	@DeleteMapping("/comentario/:{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteComentario(@PathVariable Integer id) {
		comentService.deleteComentario(id);
	}
}
