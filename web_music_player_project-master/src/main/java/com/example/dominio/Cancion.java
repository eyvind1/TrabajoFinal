package com.example.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

//import java.io.FileInputStream;
import java.util.Date;	

@Entity
public class Cancion {

  @Id
  @SequenceGenerator(name = "CANCION_ID_GENERATOR", sequenceName = "CANCION_ID_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANCION_ID_GENERATOR")
  private Integer 	ID_cancion;
  private String 	nombre;
  private String 	genero;
  private String 	letra;
  private Double 	calificacion;
  
  @ManyToOne
  @JoinColumn(name = "ARTISTA_ID")
  private Artista artista;  
  
  @ManyToOne
  @JoinColumn(name = "ALBUM_ID")
  private Album album;

  @ManyToMany (mappedBy = "canciones")
  private List<Playlist> playlistsTopTen;
  
  @OneToMany(mappedBy = "cancion")
  private List<Timeline> usuarios;
  
  public Cancion(String nombre, String genero, String letra, Album album, Artista artista) {
      this.nombre 		= nombre;
      this.genero 		= genero;
      this.letra  		= letra;
      this.album		= album;
      this.artista		= artista;
      this.calificacion = 0.00;
  }
  
  public Integer getId(){
	  return ID_cancion;
  }

  public String getNombre() {
	  return nombre;
  }

  public void setNombre(String nombre) {
	  this.nombre = nombre;
  }

  public String getGenero() {
	  return genero;
  }

  public void setGenero(String genero) {
	  this.genero = genero;
  }

  public String getLetra() {
	  return letra;
  }

  public void setLetra(String letra) {
	  this.letra = letra;
  }

  public Double getCalificacion() {
	  return calificacion;
  }

  public void setCalificacion(Double calificacion) {
	  this.calificacion = calificacion;
  }

  public Artista getArtista() {
	  return artista;
  }

  public void setArtista(Artista artista) {
	  this.artista = artista;
  }

  public Album getAlbum() {
	  return album;
  }

  public void setAlbum(Album album) {
	  this.album = album;
  }  
  
  
}
