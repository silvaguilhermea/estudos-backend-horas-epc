package com.silvaguilherme.estudoshorasepc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.silvaguilherme.estudoshorasepc.entities.Area;
import com.silvaguilherme.estudoshorasepc.entities.Atividade;
import com.silvaguilherme.estudoshorasepc.entities.Estado;
import com.silvaguilherme.estudoshorasepc.entities.Projeto;
import com.silvaguilherme.estudoshorasepc.entities.Setor;
import com.silvaguilherme.estudoshorasepc.entities.Usuario;
import com.silvaguilherme.estudoshorasepc.repositories.AreaRepository;
import com.silvaguilherme.estudoshorasepc.repositories.AtividadeRepository;
import com.silvaguilherme.estudoshorasepc.repositories.EstadoRepository;
import com.silvaguilherme.estudoshorasepc.repositories.ProjetoRepository;
import com.silvaguilherme.estudoshorasepc.repositories.SetorRepository;
import com.silvaguilherme.estudoshorasepc.repositories.UsuarioRepository;

@SpringBootApplication
public class EstudoshorasepcApplication implements CommandLineRunner {

	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private SetorRepository setorRepository;
		
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EstudoshorasepcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Area a1 = new Area(null, "P041");
		Area a2 = new Area(null, "P083");

		Setor s1 = new Setor(null, "Engenharia de Processos");
		Setor s2 = new Setor(null, "Automação");
		Setor s3 = new Setor(null, "Planejamento");
		
		Estado e1 = new Estado(null, "Aguardando");
		Estado e2 = new Estado(null, "Execução");
		Estado e3 = new Estado(null, "Revisão");
		Estado e4 = new Estado(null, "Finalizado");
		
		Usuario u1 = new Usuario(null, "Guilherme", "guilherme.dasilva", "guilherme.dasilva@butantan", "123");
		Usuario u2 = new Usuario(null, "Isabela", "isabela.quental", "isabela.quental@butantan", "321");
		Usuario u3 = new Usuario(null, "Oswaldo", "oswaldo.neto", "oswaldo.neto@butantan", "456");
		Usuario u4 = new Usuario(null, "Wiiliam", "william.goncalves", "william.goncalves@butantan", "654");
		
		Projeto p1 = new Projeto(null, "Reforma do Soros", a1, "2020-06-05", "2020-06-09");
		Projeto p2 = new Projeto(null, "Reforma da Raiva", a2, "2020-06-05", "2020-06-09");
		Projeto p3 = new Projeto(null, "CIP do mixer do Soros", a1, "2020-06-05", "2020-06-09");
		Projeto p4 = new Projeto(null, "CIP do tanque da Raiva", a2, "2020-06-05", "2020-06-09");
		
		Atividade atv1 = new Atividade (null, "Lista", p1, s1, e4, u4);
		Atividade atv2 = new Atividade (null, "Tabela", p2, s2, e3, u3);
		Atividade atv3 = new Atividade (null, "Fluxograma", p3, s3, e2, u2);
		Atividade atv4 = new Atividade (null, "Especificação", p4, s3, e1, u1);
		Atividade atv5 = new Atividade (null, "Manual", p3, s2, e2, u2);
		Atividade atv6 = new Atividade (null, "Estudo", p2, s1, e3, u3);
		Atividade atv7 = new Atividade (null, "Memorial", p1, s2, e4, u4);
		
		a1.getProjetos().addAll(Arrays.asList(p1, p3));
		a2.getProjetos().addAll(Arrays.asList(p2, p4));
		
		p1.getAtividades().addAll(Arrays.asList(atv1, atv5));
		p2.getAtividades().addAll(Arrays.asList(atv2, atv6));
		p3.getAtividades().addAll(Arrays.asList(atv3, atv7));
		p4.getAtividades().addAll(Arrays.asList(atv4));
		
		areaRepository.save(a1);
		areaRepository.save(a2);
		
		projetoRepository.save(p1);
		projetoRepository.save(p2);
		projetoRepository.save(p3);
		projetoRepository.save(p4);
		
		setorRepository.save(s1);
		setorRepository.save(s2);
		setorRepository.save(s3);
		
		estadoRepository.save(e1);
		estadoRepository.save(e2);
		estadoRepository.save(e3);
		estadoRepository.save(e4);
		
		usuarioRepository.save(u1);
		usuarioRepository.save(u2);
		usuarioRepository.save(u3);
		usuarioRepository.save(u4);
		
		atividadeRepository.save(atv1);
		atividadeRepository.save(atv2);
		atividadeRepository.save(atv3);
		atividadeRepository.save(atv4);
		atividadeRepository.save(atv5);
		atividadeRepository.save(atv6);
		atividadeRepository.save(atv7);
			
	}
}