package com.example.dominio;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Playlist {
  @Id
  @SequenceGenerator(name = "PLAYLIST_ID_GENERATOR", sequenceName = "PLAYLIST_ID_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAYLIST_ID_GENERATOR")
  private Integer	ID_playlist;
  private String 	nombre;
  private String 	fecha_creacion;

  @ManyToMany
  @JoinTable(name = "playlist_cancion",
      joinColumns = @JoinColumn(name = "PLAYLIST_ID", referencedColumnName = "ID_playlist"),
      inverseJoinColumns = @JoinColumn(name = "CANCION_ID", referencedColumnName = "ID_cancion"))
  private List<Cancion> canciones;
  
  @ManyToOne
  @JoinColumn(name = "ID_usuario")
  private Usuario usuario;
  
  public Playlist(String nombre,Integer usuario){
	  this.nombre 		= nombre;
	  this.ID_playlist 	= usuario;
	  this.fecha_creacion = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
  }

  public Integer getID_playlist() {
	  return ID_playlist;
  }

  public String getNombre() {
	  return nombre;
  }

  public void setNombre(String nombre) {
	  this.nombre = nombre;
  }

  public String getFecha_creacion() {
	  return fecha_creacion;
  }

  public void setFecha_creacion(String fecha_creacion) {
	  this.fecha_creacion = fecha_creacion;
  }	

  public Usuario getUsuario() {
	  return usuario;
  }

  public void setUsuario(Usuario usuario) {
	  this.usuario = usuario;
  }
  
  public boolean find_Cancion(Cancion cancion){
	  for(int i = 0; i < canciones.size(); i++){
		  if(canciones.get(i) == cancion){
			  return true;
		  }
	  }
	  return false;
  }
  
  public void add_Cancion(Cancion cancion){
	  canciones.add(cancion);
	  return;
  }
}

