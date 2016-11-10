package com.example.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Artista{
	
	@Id
	@SequenceGenerator(name = "Artista_ID_GENERATOR", sequenceName = "Artista_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Artista_ID_GENERATOR")
	private Integer ID_artista;
	private String nombre;
	private String bio;
	
	@OneToMany(mappedBy = "artista")
	private List<Cancion> listaCanciones;
	
	@ManyToMany
	@JoinTable(name = "Artista_Cancion",
		joinColumns = @JoinColumn(name = "Artista_ID", referencedColumnName = "ID_artista"),
		inverseJoinColumns = @JoinColumn(name = "Cancion_ID", referencedColumnName = "ID_cancion"))
	private List<Cancion> canciones_artista;
	
	@ManyToMany
	@JoinTable(name = "Artista_Album",
		joinColumns = @JoinColumn(name = "Artista_ID", referencedColumnName = "ID_artista"),
		inverseJoinColumns = @JoinColumn(name = "Album_ID", referencedColumnName = "ID_album"))
	private List<Album> albumes_artista;
	
	public Artista(String nombre,String bio){
		this.nombre = nombre;
		this.bio	= bio;
	}
	
	public List<Album> getAlbumes_artista() {
		return albumes_artista;
	}

	public void setAlbumes_artista(List<Album> albumes_artista) {
		this.albumes_artista = albumes_artista;
	}

	public Artista(String nombre_artista,List<Cancion> canciones_artista,List<Album> albums_artista) {
		this.nombre 			= nombre_artista;		
		this.canciones_artista 	= canciones_artista;
		//this.albumes_artista 	= albums_artista;
	}
	
	public Integer getId(){
		return ID_artista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public List<Cancion> GetCanciones(){
		return this.canciones_artista;
	}
	public List<Album> GetAlbumes(){
		return this.albumes_artista;
	}
	
	public boolean find_album(Album album){
		for(Album i : albumes_artista){
			if(i == album) return true;
		}
		return false;
	}
	
}