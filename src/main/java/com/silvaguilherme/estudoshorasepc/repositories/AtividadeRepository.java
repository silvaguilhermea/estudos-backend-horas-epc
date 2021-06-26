package com.silvaguilherme.estudoshorasepc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {
	
	@Query("SELECT obj FROM Atividade obj WHERE obj.projeto.name = ?1 ORDER BY obj.name ASC")
	List<Atividade> findSortByAttribute(String name);

}
