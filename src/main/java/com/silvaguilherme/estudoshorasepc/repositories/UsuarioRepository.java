package com.silvaguilherme.estudoshorasepc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("SELECT obj FROM Usuario obj ORDER BY obj.name ASC")
	List<Usuario> findSort();

}