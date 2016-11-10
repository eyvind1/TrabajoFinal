package com.example.servicio;

import java.sql.Timestamp;

import com.example.dominio.Playlist;
import com.example.dominio.Usuario;

public interface PlaylistService {
	public Playlist crearPlaylist(String nombre, Timestamp fecha_c,Usuario usr);
	public Playlist getPlaylist(Integer id);

}
