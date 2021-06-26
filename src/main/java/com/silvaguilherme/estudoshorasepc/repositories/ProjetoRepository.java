package com.silvaguilherme.estudoshorasepc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
	
	@Query("SELECT obj FROM Projeto obj WHERE obj.area.name = ?1 ORDER BY obj.name ASC")
	List<Projeto> findSortByAttribute(String name);

}
