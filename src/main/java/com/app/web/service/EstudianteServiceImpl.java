package com.app.web.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.web.dao.IEstudianteDao;
import com.app.web.entity.Estudiante;
@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteDao estudianteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> findAll() {
		// TODO Auto-generated method stub
		return estudianteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Estudiante findById(Long id) {
		// TODO Auto-generated method stub
		return estudianteDao.findById(id).isPresent()?
				estudianteDao.findById(id).get():null;
	}

	@Override
	@Transactional
	public Estudiante save(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return estudianteDao.save(estudiante);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		estudianteDao.deleteById(id);
	}

	

}
