package com.example.servicio;

import com.example.dominio.Album;
import com.example.dominio.Artista;

public interface AdministradorService {
	boolean agregarArtista(Artista artista);
	boolean agregarAlbum(Album album);
}
