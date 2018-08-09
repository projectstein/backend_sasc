package com.projectstein.backend_sasc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectstein.backend_sasc.domain.Administrador;
import com.projectstein.backend_sasc.domain.Aluno;
import com.projectstein.backend_sasc.domain.CriticaSugestaoElogio;
import com.projectstein.backend_sasc.domain.Funcionario;

import com.projectstein.backend_sasc.domain.enums.Funcao;
import com.projectstein.backend_sasc.domain.enums.TipoLogin;
import com.projectstein.backend_sasc.repository.CriticaSugestaoElogioRepository;

import com.projectstein.backend_sasc.repository.PessoaRepository;

@SpringBootApplication
public class BackendSascApplication implements CommandLineRunner {

	@Autowired
	private CriticaSugestaoElogioRepository criticaSugestaoElogioRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendSascApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Administrador adm = new Administrador(null, "11511644702", "Felipe Stein Rosa", "projectstein@gmail.com",
				TipoLogin.ADMINISTRADOR, "SASC@gmail.com", "123456");
		Funcionario fn1 = new Funcionario(null, "69831921097", "Vitoria gostosa", "delicia@gmail.com",
				TipoLogin.FUNCIONARIO, Funcao.PROFESSOR, adm);
		Aluno aln1 = new Aluno(null, "10333564090", "Arthur bosta", "Arthur.bosta@gmail.com", TipoLogin.ALUNO, adm);
		Aluno aln2 = new Aluno(null, "55563625052", "Robsom Macedo", "Robson.Macedo@gmail.com", TipoLogin.ALUNO, fn1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		CriticaSugestaoElogio cse1 = new CriticaSugestaoElogio(null, "teste", sdf.parse("17/07/2018"), aln1);
		cse1.setAluno(aln1);

		CriticaSugestaoElogio cse2 = new CriticaSugestaoElogio(null, "teste2", sdf.parse("19/08/2018"), aln2);
		cse2.setAluno(aln2);

		pessoaRepository.save(Arrays.asList(adm, fn1, aln1, aln2));

		criticaSugestaoElogioRepository.save(Arrays.asList(cse1, cse2));

	}
}
