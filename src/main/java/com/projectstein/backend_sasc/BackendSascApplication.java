package com.projectstein.backend_sasc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectstein.backend_sasc.domain.CriticaSugestaoElogio;
import com.projectstein.backend_sasc.repository.CriticaSugestaoElogioRepository;

@SpringBootApplication
public class BackendSascApplication implements CommandLineRunner {
	
	
	@Autowired
		private CriticaSugestaoElogioRepository criticaSugestaoElogioRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(BackendSascApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		CriticaSugestaoElogio cse1= new CriticaSugestaoElogio(null, "teste", sdf.parse("17/07/2018")); 
		CriticaSugestaoElogio cse2= new CriticaSugestaoElogio(null, "teste2", sdf.parse("19/08/2018")); 
		
		criticaSugestaoElogioRepository.save(Arrays.asList(cse1,cse2));
		
		
	}
}
