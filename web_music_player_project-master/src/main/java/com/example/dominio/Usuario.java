package com.example.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario {
	@Id
	@SequenceGenerator(name = "Persona_ID_GENERATOR", sequenceName = "Persona_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Persona_ID_GENERATOR")
	private Integer ID_usuario;
	private String username;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String email;
	private String password;
	private Boolean state; // Activo o Inactivo
	
	//Crear tabla seguidores_seguidos	
	@ManyToMany
	@JoinTable(name = "following_followers",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID_usuario", nullable = false),
		inverseJoinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "ID_usuario",nullable = false))
	private List<Usuario> seguidores;
	
	@ManyToMany
	@JoinTable(name = "Usuario_siguiendo",
		joinColumns = @JoinColumn(name = "Usuario_ID", referencedColumnName = "ID_usuario"),
		inverseJoinColumns = @JoinColumn(name = "Siguiendo_ID", referencedColumnName = "ID_usuario"))
	public List<Usuario> siguiendo;
	
	//relaciones para el timeline
	@OneToMany(mappedBy="usuario")
	private List<Timeline> canciones;
	
	//getters and setters
	public Usuario(String username,String nombres, String apellidoPaterno, String apellidoMaterno, String email, String password) {
		this.username			= username;
		this.nombres 			= nombres;
        this.apellidoPaterno 	= apellidoPaterno;
        this.apellidoMaterno    = apellidoMaterno;
        this.email				= email;
        this.password			= password;
        this.state				= true;
    }
	
	public Integer getId(){
		return ID_usuario;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	
	public void add_siguiendo(Usuario usuario){
		siguiendo.add(usuario);
	}
	
	public List<Usuario> get_siguiendo(){
		return this.siguiendo;
	}
	
	public Usuario buscar(List<Usuario> usuarios, Usuario usuario){
		for(Usuario i : usuarios){
			if(i == usuario) return usuario;
		}
		return null;
	}
	
	public void delete_siguiendo(Usuario usuario){
		int index = 0;
		for(int i = 0; i < siguiendo.size(); i++){
			if(siguiendo.get(i) == usuario) {index = i;}
		}
		siguiendo.remove(index);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
	