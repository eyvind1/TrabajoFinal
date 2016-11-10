package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
public class Album{
	@Id
	@SequenceGenerator(name = "Album_ID_GENERATOR", sequenceName = "Album_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Album_ID_GENERATOR")
	private Integer ID_album;
	private String nombre;	
	private Timestamp fechaCreacion;
	private List<Cancion> Canciones_Album;
	@ManyToMany
	@JoinTable(name = "album_artista",
	      joinColumns = @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID_album"),
	      inverseJoinColumns = @JoinColumn(name = "ARTISTA_ID", referencedColumnName = "ID_artista"))
	private List<Artista> listaArtistas;
	
	
	public Album (String nombre, Timestamp fecha_c){
		this.nombre 		= nombre;
		this.fechaCreacion 	= fecha_c;
	}
	
	public Integer getId(){
		return ID_album;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Artista> getListaArtistas() {
		return listaArtistas;
	}

	public void setListaArtistas(List<Artista> listaArtistas) {
		this.listaArtistas = listaArtistas;
	}
	public List<Cancion> getCanciones_Album(){
		return this.Canciones_Album;
	}
}
