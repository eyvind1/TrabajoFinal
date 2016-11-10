package com.example.servicio;

import java.sql.Timestamp;

import com.example.dominio.Album;

public interface AlbumService {
	public Album crearAlbum(String nombre, Timestamp fecha_c);
	public Album getAlbum(Integer id);
}