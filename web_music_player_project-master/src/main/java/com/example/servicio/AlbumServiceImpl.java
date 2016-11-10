package com.example.servicio;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dominio.Album;
import com.example.repositorio.AlbumRepositorio;

public class AlbumServiceImpl {
	@Autowired
    private AlbumRepositorio albumRepositorio;
	
	public Album crearAlbum(String nombre, Timestamp fecha_c){
		Album album = new Album(nombre,fecha_c);
		albumRepositorio.save(album);
		return album;
	}
	
	public Album getAlbum(Integer id){
		return albumRepositorio.findOne(id);
	}
}
