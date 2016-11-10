package com.example.controlador;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repositorio.UsuarioRepositorio;
import com.example.repositorio.AdministradorRepositorio;

@RestController
public class WebPlayerControlador {
	//Controlador usuario
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	@RequestMapping(value = "account/current", method = RequestMethod.GET)
	public String account(Principal principal) {
		return "redirect:/" + principal.getName() + "/playlists";
	}
	
	
	@Autowired
	AdministradorRepositorio AdministradorRepositorio;
	
	
}
