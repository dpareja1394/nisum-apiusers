package com.nisum.apiusuarios.repository;

import com.nisum.apiusuarios.domain.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParamRepository extends JpaRepository<Param, String> {

}
