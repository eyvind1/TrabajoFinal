package com.example.servicio;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dominio.Cancion;
import com.example.dominio.Playlist;
import com.example.dominio.Usuario;
import com.example.repositorio.CancionRepositorio;
import com.example.repositorio.PlaylistRepositorio;
import com.example.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServiceImpl implements UsuarioService {


	UsuarioRepositorio usuarioRepositorio;
	PlaylistRepositorio playlistRepositorio;
	CancionRepositorio cancionRepositorio;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepositorio ur, PlaylistRepositorio pr, CancionRepositorio cr){
		this.usuarioRepositorio = ur;
		this.playlistRepositorio = pr;
		this.cancionRepositorio = cr;
	}
	
	public Usuario crearUsuario(String username,String nombres, String apellidoPaterno, String apellidoMaterno, String email, String password){
		Usuario usuario = new Usuario(username,nombres,apellidoPaterno,apellidoMaterno,email,password);
		usuarioRepositorio.save(usuario);
		return usuario;
	}
	
	public void updateUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }
	
	public Usuario getUsuario(Integer ID_usuario) {
        return usuarioRepositorio.findOne(ID_usuario);
    }
	

	/*@Transactional
	@Override
	public boolean crear_playlist(String nombre, Integer usuario_id) {
		Playlist playlist = usuarioRepositorio.Buscar_Playlist(nombre, usuario_id);
		if(playlist != null) return false;
		playlist = new Playlist(nombre, usuario_id);
		playlistRepositorio.save(playlist);
		return true;
	}
*/
	@Transactional
	@Override
	public boolean agregar_cancion(Integer cancion_id, Integer playlist_id) {
		Playlist playlist = playlistRepositorio.findOne(playlist_id);
		Cancion Cancion = cancionRepositorio.findOne(cancion_id);
		if(playlist.find_Cancion(Cancion))		return false;
		playlist.add_Cancion(Cancion);
		return true;
	}

	@Transactional
	@Override
	public boolean seguir_usuario(Integer usuario_id,Integer usuario_id2) {
		Usuario principal = usuarioRepositorio.findOne(usuario_id);
		Usuario a_seguir = usuarioRepositorio.findOne(usuario_id2);
		if(principal.buscar(principal.get_siguiendo(), a_seguir) != null) return false;
		principal.add_siguiendo(a_seguir);
		return true;
	}

	@Transactional
	@Override
	public boolean stop_seguir(Integer usuario_id, Integer usuario_id2) {
		Usuario principal = usuarioRepositorio.findOne(usuario_id);
		Usuario a_no_seguir = usuarioRepositorio.findOne(usuario_id2);
		if(principal.buscar(principal.get_siguiendo(), a_no_seguir)== null) return false;
		principal.delete_siguiendo(a_no_seguir);
		return true;
	}
	
	@Transactional
	@Override
	public boolean cerrar_sesion(Integer usuario_id) {
		//Usuario muerto = usuarioRepositorio.findOne(usuario_id);
		//ExUsuario vivo = (ExUsuario) muerto;
		usuarioRepositorio.Eliminarse(usuario_id);
		//ExUsuarioRepositorio.save(vivo);
		return false;
	}
	@Transactional
	@Override
	public boolean agregar_cancion(Cancion cancion, Playlist playlist) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
