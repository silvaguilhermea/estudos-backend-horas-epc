package com.silvaguilherme.estudoshorasepc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {
	
	@Query("SELECT obj FROM Setor obj ORDER BY obj.name ASC")
	List<Setor> findSort();

}