package com.silvaguilherme.estudoshorasepc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Apontamento;

@Repository
public interface ApontamentoRepository extends JpaRepository<Apontamento, Integer> {
	
	@Query("SELECT obj FROM Apontamento obj WHERE obj.responsavel = ?1 ORDER BY obj.dataInicial ASC")
	List<Apontamento> findSortByAttribute(String name);

}