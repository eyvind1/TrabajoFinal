package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Administrador {
	@Id
	@SequenceGenerator(name = "Persona_ID_GENERATOR", sequenceName = "Persona_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Persona_ID_GENERATOR")
	private Integer ID_adm;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String username;
	private String password;
	
	public Administrador(String nombres, String apellidoPaterno, String apellidoMaterno, String username, String password) {
		this.nombres 			= nombres;
        this.apellidoPaterno 	= apellidoPaterno;
        this.apellidoMaterno    = apellidoMaterno;
        this.username			= username;
        this.password			= password;
    }

	public Integer getId(){
		return ID_adm;
	}
	
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
