package com.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.web.entity.Estudiante;
import com.app.web.service.IEstudianteService;

@Controller
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping({"/estudiantes","/"})
	public String findAll(Model modelo){
		modelo.addAttribute("estudiantes", estudianteService.findAll());
		return "estudiantes"; // nombre del archivo html
	}
	
	@GetMapping({"/estudiantes/nuevo"})
	public String mostrarFormularioGuardar(Model modelo){
		Estudiante estudiante = new Estudiante();		
		modelo.addAttribute("estudiante", estudiante);
		return "crear_estudiante";
	}
	
	@PostMapping({"/estudiantes"})
	public String salvar(@ModelAttribute("estudiante") Estudiante estudiante){
		estudianteService.save(estudiante);
		return "redirect:/estudiantes";
	}
	
	@GetMapping({"/estudiantes/{id}"})
	public String eliminar(@PathVariable Long id){
		estudianteService.delete(id);
		return "redirect:/estudiantes";
	}
	
	@GetMapping({"/estudiantes/editar/{id}"})
	public String mostrarFormularioEditar(Model modelo,@PathVariable Long id){
		Estudiante estudiante = estudianteService.findById(id);		
		modelo.addAttribute("estudiante", estudiante);
		return "editar_estudiante";
	}
	
	@PostMapping({"/estudiantes/{id}"})
	public String editar(@ModelAttribute("estudiante") Estudiante estudiante,
			@PathVariable Long id, Model modelo){
		Estudiante est = estudianteService.findById(id);
		est.setId(id);
		est.setNombre(estudiante.getNombre());
		est.setApellido(estudiante.getApellido());
		est.setEmail(estudiante.getEmail());
		estudianteService.save(est);
		return "redirect:/estudiantes";
	}
	
	@GetMapping({"/estudiantes/detalle/{id}"})
	public String mostrarDetalle(Model modelo,@PathVariable Long id){
		Estudiante estudiante = estudianteService.findById(id);		
		modelo.addAttribute("estudiante", estudiante);
		return "detalle_estudiante";
	}
}
