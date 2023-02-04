package com.nisum.apiusuarios.repository;

import com.nisum.apiusuarios.domain.Parametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroRepository extends JpaRepository<Parametro, String> {

}
