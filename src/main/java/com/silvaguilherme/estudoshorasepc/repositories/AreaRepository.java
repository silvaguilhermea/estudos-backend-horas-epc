package com.silvaguilherme.estudoshorasepc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

}