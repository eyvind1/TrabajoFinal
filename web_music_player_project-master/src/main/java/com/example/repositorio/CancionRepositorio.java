package com.example.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dominio.Cancion;

public interface CancionRepositorio extends CrudRepository<Cancion, Integer> {
	List<Cancion> findAll();
}