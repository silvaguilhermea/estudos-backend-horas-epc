package com.silvaguilherme.estudoshorasepc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	@Query("SELECT obj FROM Estado obj ORDER BY obj.name ASC")
	List<Estado> findSort();

}