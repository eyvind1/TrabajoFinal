package com.example.servicio;

import com.example.dominio.Cancion;
import com.example.dominio.Playlist;
import com.example.dominio.Usuario;
import com.example.repositorio.CancionRepositorio;
import com.example.repositorio.PlaylistRepositorio;
import com.example.repositorio.UsuarioRepositorio;

public interface UsuarioService {
	
	//public Usuario crearUsuario(String nombres, String apellidoPaterno, String apellidoMaterno, String email, String password); //throws Exception;
	public void updateUsuario(Usuario usuario);
	public Usuario getUsuario(Integer id);
	//boolean crear_playlist(String nombre, Integer usuario_id);
	boolean agregar_cancion(Cancion cancion, Playlist playlist);
	boolean agregar_cancion(Integer cancion_id, Integer playlist_id);
	boolean seguir_usuario(Integer usuario_id, Integer usuario_id2);
	boolean stop_seguir(Integer usuario_id, Integer usuario_id2);
	boolean cerrar_sesion(Integer usuario_id);
	
}
