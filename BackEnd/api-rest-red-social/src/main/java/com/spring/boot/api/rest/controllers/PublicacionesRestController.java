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

import com.spring.boot.api.rest.entity.Publicaciones;
import com.spring.boot.api.rest.service.PublicacionesServiceImp;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PublicacionesRestController {
	
	@Autowired
	private PublicacionesServiceImp publService;
	
	@GetMapping("/publicaciones")
	public List<Publicaciones>  getPublics(){
		return publService.getPublicaciones();
	}
	
	@GetMapping("/publId/:{id}")
	@ResponseStatus(HttpStatus.OK)
	public Publicaciones getPublId(@PathVariable Integer id) {
		return publService.getPublId(id);
	}
	//resquestbody: es para insertar los datos enviados por el json, del cuerpo de la peticion
	//no se envia el id
	@PostMapping("/publicacion")
	@ResponseStatus(HttpStatus.CREATED)
	public Publicaciones savePubl(@RequestBody Publicaciones publ) {
		return publService.savePubl(publ);
	}
	//aqui si se necesita un metodo especifico para actualizar
	@PutMapping("/publicacion/:{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Publicaciones updatePubl(@RequestBody Publicaciones publ, @PathVariable Integer id){
		Publicaciones publiActual = publService.getPublId(id);
		publiActual.setDescripcion(publ.getDescripcion());
		publiActual.setNombreImg(publ.getNombreImg());
		publiActual.setRutaImg(publ.getRutaImg());
		return publService.savePubl(publiActual);
	}
	@DeleteMapping("/publicacion/:{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePubl(@PathVariable Integer id) {
		publService.deletePubli(id);
	}
	
}
