package com.silvaguilherme.estudoshorasepc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	@Query("SELECT e FROM Estado e WHERE e.name = ?1")
	List<Estado> findByName(String name);
	
	@Query("SELECT e FROM Estado e ORDER BY e.name DESC")
	List<Estado> findSort();

}