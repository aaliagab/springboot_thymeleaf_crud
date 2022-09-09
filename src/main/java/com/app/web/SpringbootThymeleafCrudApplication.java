package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.app.web.entity.Estudiante;
import com.app.web.service.IEstudianteService;

@SpringBootApplication
public class SpringbootThymeleafCrudApplication implements CommandLineRunner{

	@Autowired
	private IEstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeleafCrudApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Estudiante est1 = new Estudiante();
		est1.setNombre("Adriel");
		est1.setApellido("Aliaga Benavides");
		est1.setEmail("a@a.aa");
		
		Estudiante est2 = new Estudiante();
		est2.setNombre("Yudisel");
		est2.setApellido("Santana Pacheco");
		est2.setEmail("a@a.aa");
		
		Estudiante est3 = new Estudiante();
		est3.setNombre("Amelia");
		est3.setApellido("Aliaga Santana");
		est3.setEmail("a@a.aa");
		
		estudianteService.save(est1);
		estudianteService.save(est2);
		estudianteService.save(est3);
	}

}
