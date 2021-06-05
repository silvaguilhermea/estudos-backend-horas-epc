package com.silvaguilherme.estudoshorasepc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvaguilherme.estudoshorasepc.entities.Apontamento;

@Repository
public interface ApontamentoRepository extends JpaRepository<Apontamento, Integer> {

}