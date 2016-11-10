package com.example.servicio;

import com.example.dominio.Album;

public interface ArtistaService {
	public boolean Agregar_Album(Integer artista_id, Album album);
	public boolean Eliminar_Album(Integer artista_id, Integer album_id);
}
