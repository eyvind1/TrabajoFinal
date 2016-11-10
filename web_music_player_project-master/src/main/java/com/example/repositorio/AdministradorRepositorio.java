package com.example.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.dominio.Administrador;

public interface AdministradorRepositorio extends CrudRepository<Administrador, Integer> {
	List<Administrador> findAll();
	
	@Query("DELETE FROM Artista c WHERE c.ID_artista = ?1")
	boolean deleteArtista(Integer Id_artista);
	
	@Query("DELETE FROM Artista c WHERE c.ID_artista = ?1")
	boolean Eliminar_Artista(Integer Id_artista);
	
	@Query("DELETE FROM Album c WHERE c.ID_album = ?1")
	boolean Eliminar_Album(Integer Album_id);
}
