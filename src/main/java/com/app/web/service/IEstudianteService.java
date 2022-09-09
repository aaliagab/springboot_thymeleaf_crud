package com.app.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.entity.Estudiante;

public interface IEstudianteService{
	public List<Estudiante> findAll();
	public Estudiante findById(Long id);
	public Estudiante save(Estudiante estudiante);
	public void delete(Long id);
}
