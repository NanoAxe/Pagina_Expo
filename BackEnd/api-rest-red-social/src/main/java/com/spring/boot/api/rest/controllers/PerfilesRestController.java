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

import com.spring.boot.api.rest.entity.Perfiles;
import com.spring.boot.api.rest.service.IPerfilService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PerfilesRestController {

	@Autowired
	private IPerfilService perfilService;
	
	@GetMapping("/perfiles")
	public List<Perfiles> getPerfiles(){
		return perfilService.getPerfiles();
	}
	
	@GetMapping("/perfil/:{id}")
	public Perfiles getPerfilId(@PathVariable Integer id) {
		return perfilService.getPerfil(id);
	}
	
	@PostMapping("/perfil")
	@ResponseStatus(HttpStatus.CREATED)
	public Perfiles savePerfil(@RequestBody Perfiles perfil) {
		return perfilService.savePerfil(perfil);
	}
	
	@PutMapping("/perfil/:{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Perfiles updatePerfil(@RequestBody Perfiles perfil, @PathVariable Integer id) {
		Perfiles perfilActual = perfilService.getPerfil(id);
		perfilActual.setApellido(perfil.getApellido());
		perfilActual.setNombre(perfil.getNombre());
		perfilActual.setNombreFoto(perfil.getNombreFoto());
		perfilActual.setRutaFoto(perfil.getRutaFoto());
		return perfilService.savePerfil(perfilActual);
	}
	
	@DeleteMapping("/perfil/:{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePerfil(@PathVariable Integer id) {
		perfilService.deletePerfil(id);
	}
}
