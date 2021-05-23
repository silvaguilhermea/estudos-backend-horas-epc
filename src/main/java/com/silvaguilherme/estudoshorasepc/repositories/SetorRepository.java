package com.silvaguilherme.estudoshorasepc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

}