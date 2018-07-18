package com.projectstein.backend_sasc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectstein.backend_sasc.domain.CriticaSugestaoElogio;

@Repository
public interface CriticaSugestaoElogioRepository extends JpaRepository<CriticaSugestaoElogio , Integer> {

}
