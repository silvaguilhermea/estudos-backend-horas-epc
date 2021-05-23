package com.silvaguilherme.estudoshorasepc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
