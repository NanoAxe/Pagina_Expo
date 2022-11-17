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

import com.spring.boot.api.rest.entity.Usuarios;
import com.spring.boot.api.rest.service.UsuariosServiceImp;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private UsuariosServiceImp usuarioService;
	
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)//es por defecto, son las respuestas de la api
	public List<Usuarios> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	//("/ruta/:{parametros}")
	//pathvariable es para capturar el dato/parametro
	
	@GetMapping("/usuarioId/:{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuarios getUsuarioId(@PathVariable Integer id) {
		return usuarioService.getUsuarioId(id);
	}
	//resquestbody: es para insertar los datos enviados por el json, del cuerpo de la peticion
	//no se envia el id
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuarios saveUsuario(@RequestBody Usuarios usuario) {
		return usuarioService.saveUsuario(usuario);
	}
	//aqui si se necesita un metodo especifico para actualizar
	@PutMapping("/usuario/:{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuarios updateUsuario(@RequestBody Usuarios usuario, @PathVariable Integer id){
		Usuarios usuarioActual = usuarioService.getUsuarioId(id);
		usuarioActual.setCorreo(usuario.getCorreo());
		usuarioActual.setPassword(usuario.getPassword());
		usuarioActual.setUsuario(usuario.getUsuario());
		return usuarioService.saveUsuario(usuarioActual);
	}
	@DeleteMapping("/usuario/:{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUsuario(@PathVariable Integer id) {
		usuarioService.deleteUsuario(id);
	}
}
