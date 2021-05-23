package com.silvaguilherme.estudoshorasepc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

}
