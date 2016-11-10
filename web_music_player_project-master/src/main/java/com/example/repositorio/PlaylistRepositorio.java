package com.example.repositorio;

import com.example.dominio.Administrador;
import com.example.dominio.Cancion;
import com.example.dominio.Playlist;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.List;

public interface PlaylistRepositorio extends CrudRepository<Playlist, Integer> {
    List<Playlist> findAll();
}
