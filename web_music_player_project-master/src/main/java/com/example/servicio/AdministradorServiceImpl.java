package com.example.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dominio.Album;
import com.example.dominio.Artista;
import com.example.dominio.Cancion;
import com.example.repositorio.AdministradorRepositorio;
import com.example.repositorio.AlbumRepositorio;
import com.example.repositorio.ArtistaRepositorio;

public class AdministradorServiceImpl implements AdministradorService{
	
	AdministradorRepositorio administradorRepositorio;
	ArtistaRepositorio artistaRepositorio;
	AlbumRepositorio albumRepositorio;
	
	@Autowired
	public AdministradorServiceImpl(AdministradorRepositorio ar, ArtistaRepositorio arr, AlbumRepositorio alr){
		this.administradorRepositorio = ar;
		this.artistaRepositorio = arr;
		this.albumRepositorio = alr;
	}
	
	@Transactional
	@Override
	public boolean agregarArtista(Artista artista) {
		List<Cancion> Canciones =  artista.GetCanciones();
		List<Album> Albumes = artista.GetAlbumes();
		if(Canciones.size() == 0 || Albumes.size() == 0)	return false;
		artistaRepositorio.save(artista);
		return true;
	}
	
	@Transactional
	@Override
	public boolean agregarAlbum(Album album) {
		List<Cancion> Canciones =  album.getCanciones_Album();
		if(Canciones.size() == 0)	return false;
		albumRepositorio.save(album);
		return true;
	}
}
