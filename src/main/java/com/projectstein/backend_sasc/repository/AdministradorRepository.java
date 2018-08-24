package com.projectstein.backend_sasc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectstein.backend_sasc.domain.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador , Integer> {

}
