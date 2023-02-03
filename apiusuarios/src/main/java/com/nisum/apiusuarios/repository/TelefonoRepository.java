package com.nisum.apiusuarios.repository;

import com.nisum.apiusuarios.domain.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono, String> {
}
