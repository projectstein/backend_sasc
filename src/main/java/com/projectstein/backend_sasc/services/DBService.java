package com.projectstein.backend_sasc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.Administrador;
import com.projectstein.backend_sasc.domain.Aluno;
import com.projectstein.backend_sasc.domain.Avaliacao;
import com.projectstein.backend_sasc.domain.CriticaSugestaoElogio;
import com.projectstein.backend_sasc.domain.Funcionario;
import com.projectstein.backend_sasc.domain.Pergunta;
import com.projectstein.backend_sasc.domain.Resposta;
import com.projectstein.backend_sasc.domain.enums.Funcao;
import com.projectstein.backend_sasc.domain.enums.Perfil;
import com.projectstein.backend_sasc.domain.enums.TipoResposta;
import com.projectstein.backend_sasc.repository.AdministradorRepository;
import com.projectstein.backend_sasc.repository.AlunoRepository;
import com.projectstein.backend_sasc.repository.AvaliacaoRepository;
import com.projectstein.backend_sasc.repository.CriticaSugestaoElogioRepository;
import com.projectstein.backend_sasc.repository.FuncionarioRepository;
import com.projectstein.backend_sasc.repository.PerguntaRepository;
import com.projectstein.backend_sasc.repository.RespostaRepository;

@Service
public class DBService {

	@Autowired
	private CriticaSugestaoElogioRepository criticaSugestaoElogioRepository;
	@Autowired
	private AdministradorRepository administradorRepository;
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private PerguntaRepository perguntaRepository;
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	@Autowired
	private RespostaRepository respostaRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Administrador adm = new Administrador(null, "11511644702", "Felipe Stein Rosa", "projectstein@gmail.com",
				Perfil.ADMINISTRADOR, "SASC@gmail.com", "123456");
		Funcionario fn1 = new Funcionario(null, "69831921097", "Vitoria gostosa", "delicia@gmail.com",
				Perfil.FUNCIONARIO, Funcao.PROFESSOR, adm);
		Aluno aln1 = new Aluno(null, "10333564090", "Arthur bosta", "Arthur.bosta@gmail.com", adm);
		Aluno aln2 = new Aluno(null, "55563625052", "Robson Macedo", "Robson.Macedo@gmail.com", fn1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		CriticaSugestaoElogio cse1 = new CriticaSugestaoElogio(null, "teste", sdf.parse("17/07/2018"), aln1);
		CriticaSugestaoElogio cse2 = new CriticaSugestaoElogio(null, "teste2", sdf.parse("19/08/2018"), aln2);
		
		Pergunta p1 = new Pergunta(null, "Como você avalia o conhecimento do professor?",
									Funcao.PROFESSOR, sdf.parse("17/07/2018"), adm);
	
		
		Avaliacao av1 = new Avaliacao(null, new Date(System.currentTimeMillis()), Funcao.PROFESSOR, fn1, aln1);
		
		Resposta r1 = new Resposta(TipoResposta.BOM, av1, p1); 
		
		av1.getResposta().addAll(Arrays.asList(r1));
		
		
		administradorRepository.save(Arrays.asList(adm));
		funcionarioRepository.save(Arrays.asList(fn1));
		alunoRepository.save(Arrays.asList(aln1,aln2));
		criticaSugestaoElogioRepository.save(Arrays.asList(cse1, cse2));
		perguntaRepository.save(Arrays.asList(p1));
		avaliacaoRepository.save(Arrays.asList(av1));
		respostaRepository.save(Arrays.asList(r1));
		
	}
	
}
