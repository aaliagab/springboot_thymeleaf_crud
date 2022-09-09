package com.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.web.entity.Estudiante;
import com.app.web.service.IEstudianteService;

@Controller
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping({"/estudiantes","/"})
	public String findAll(Model modelo){
		modelo.addAttribute("estudiantes", estudianteService.findAll());
		return "estudiantes";
	}
}
