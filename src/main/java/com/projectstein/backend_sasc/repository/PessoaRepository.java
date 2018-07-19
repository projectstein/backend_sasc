package com.projectstein.backend_sasc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectstein.backend_sasc.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa , Integer> {

}
