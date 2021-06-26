package com.silvaguilherme.estudoshorasepc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
	
	@Query("SELECT obj FROM Area obj ORDER BY obj.name ASC")
	List<Area> findSort();

}