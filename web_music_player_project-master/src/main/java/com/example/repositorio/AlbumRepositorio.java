package com.example.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dominio.Album;

public interface AlbumRepositorio extends CrudRepository<Album, Integer> {
	List<Album> findAll();
}