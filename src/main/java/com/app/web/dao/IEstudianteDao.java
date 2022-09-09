package com.app.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entity.Estudiante;

@Repository
public interface IEstudianteDao extends JpaRepository<Estudiante, Long>{

}
