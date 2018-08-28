package com.projectstein.backend_sasc.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectstein.backend_sasc.domain.CriticaSugestaoElogio;

@Repository
public interface CriticaSugestaoElogioRepository extends JpaRepository<CriticaSugestaoElogio , Integer> {

	
	@Transactional(readOnly=true)
	Page<CriticaSugestaoElogio> findByMesAndAno(Integer mes, Integer ano, Pageable pageRequest);
	
	@Transactional(readOnly=true)
	List<CriticaSugestaoElogio> findByMes(Integer mes);
	
	@Transactional(readOnly=true)
	List<CriticaSugestaoElogio> findByAno(Integer ano);
	
	
}
