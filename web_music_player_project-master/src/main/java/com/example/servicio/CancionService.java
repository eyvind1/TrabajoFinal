package com.example.servicio;

import com.example.dominio.Album;
import com.example.dominio.Artista;
import com.example.dominio.Cancion;

public interface CancionService {
	public Cancion crearCancion(String nombre,String genero,String letra, Album album, Artista artista );
	public Cancion getSong(Integer id);
}
