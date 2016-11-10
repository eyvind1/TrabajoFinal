package com.example.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.dominio.Album;
import com.example.dominio.Cancion;
import com.example.dominio.Playlist;
import com.example.dominio.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
	List<Usuario> findAll();
	
	@Query("SELECT c FROM Usuario c WHERE c.username = ?1 AND c.password = ?2")
	Usuario login_usuario(String username, String password);
		
	@Query("SELECT c FROM Usuario c WHERE c.nombres = ?1 or CONCAT (c.ID_usuario, '') = ?1")
	Usuario find_usuario(String usuario);
	
	@Query("DELETE FROM Playlist c WHERE c.ID_playlist = ?1")
	boolean Eliminar_playlist(Integer playlist_id);
	
	@Query("DELETE FROM Usuario c WHERE c.ID_usuario = ?1")
	boolean Eliminarse(Integer ID_usuario);
	
	@Query("SELECT c FROM Playlist c WHERE c.nombre = ?1 AND c.Usuario.ID_usuario = ?2")
	Playlist Buscar_Playlist(String nombre, Integer ID_usuario);
	
	//@Query("SELECT c FROM playlist c WHERE c.nombre = ?1 AND c.usuario_id = ?2")
	//Playlist Buscar_Playlist(String nombre, Usuario ID_usuario);
	
	@Query("SELECT c FROM Cancion c WHERE c.nombre LIKE ?1"+"%")
	List<Cancion> Buscar_Cancion(String nombre);
	
	@Query("SELECT c FROM Album c WHERE c.nombre LIKE ?1"+"%")
	List<Album> Buscar_Album(String nombre);
	
	@Query("SELECT c FROM Usuario c WHERE c.ID_usuario = ?1")
	Usuario find_usuario2(Integer usuario);
	
	@Query("SELECT c.seguidores FROM Usuario c WHERE c.username = ?1")
	List<Usuario> find_seguidores_id(String usuario);
}
