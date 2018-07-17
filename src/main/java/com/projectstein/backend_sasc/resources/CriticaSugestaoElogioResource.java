package com.projectstein.backend_sasc.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectstein.backend_sasc.domain.CriticaSugestaoElogio;

@RestController
@RequestMapping(value = "/cses")
public class CriticaSugestaoElogioResource {
	
	@RequestMapping(method= RequestMethod.GET)
	public List<CriticaSugestaoElogio> listar() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		CriticaSugestaoElogio cse1= new CriticaSugestaoElogio(1, "teste", sdf.parse("17/07/2018")); 
		CriticaSugestaoElogio cse2= new CriticaSugestaoElogio(2, "teste2", sdf.parse("17/07/2018")); 
		
		List<CriticaSugestaoElogio> lista = new ArrayList<>(); 
		
		lista.add(cse1);
		lista.add(cse2);
		
		
		return lista;
	}

	
	
	
	
}
