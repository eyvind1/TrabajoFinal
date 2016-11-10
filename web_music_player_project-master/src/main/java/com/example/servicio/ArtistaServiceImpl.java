package com.example.servicio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dominio.Album;
import com.example.dominio.Artista;
import com.example.repositorio.AlbumRepositorio;
import com.example.repositorio.ArtistaRepositorio;

public class ArtistaServiceImpl implements ArtistaService{
	
	ArtistaRepositorio artistaRepositorio;
	AlbumRepositorio albumRepositorio;
	
	@Autowired
	public ArtistaServiceImpl(ArtistaRepositorio ar, AlbumRepositorio alr){
		this.artistaRepositorio = ar;
		this.albumRepositorio = alr;
	}
	
	@Transactional
	@Override
	public boolean Agregar_Album(Integer artista_id, Album album) {
		albumRepositorio.save(album);
		Artista artista = artistaRepositorio.findOne(artista_id);
		artista.GetAlbumes().add(album);
		return true;
	}

	@Transactional
	@Override
	public boolean Eliminar_Album(Integer artista_id, Integer album_id) {
		Album album = albumRepositorio.findOne(album_id);
		if(album == null) return false;
		Artista artista = artistaRepositorio.findOne(artista_id);
		if(artista.find_album(album) == false) return false;
		artista.GetAlbumes().add(album);
		return true;
	}

}
