package it.uniroma3.siw.spring.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.siw.spring.controller.validator.LibroValidator;
import it.uniroma3.siw.spring.model.Libro;
import it.uniroma3.siw.spring.service.LibroService;
import it.uniroma3.siw.spring.model.Autore;
import it.uniroma3.siw.spring.service.AutoreService;
import it.uniroma3.siw.spring.model.Editore;
import it.uniroma3.siw.spring.service.EditoreService;

@Controller
public class LibroController {

	@Autowired
	private LibroService service;
	
	@Autowired
	private AutoreService autoreService;
	
	@Autowired
	private EditoreService editoreService;
	
	@Autowired
	private LibroValidator validator;
	
	@RequestMapping(value="/libro", method = RequestMethod.GET)
	public String getLibro(Model model) {
		model.addAttribute("libro", new Libro());
		List<Autore> autori = autoreService.findAll();
		model.addAttribute("autori", autori);
		List<Editore> editori = editoreService.findAll();
		model.addAttribute("editori", editori);
		return "libroForm.html";
	}
	
	@RequestMapping(value = "/libro", method = RequestMethod.POST)
	public String addLibro(@ModelAttribute("libro") Libro libro, Model model, BindingResult binding) {
		validator.validate(libro, binding);
		if(!binding.hasErrors()) {
			service.save(libro);
			model.addAttribute("libri", service.findAll());
			return "libri.html";
		}
		else return "libroForm.html";
	}
	
	@RequestMapping(value = "/libri", method = RequestMethod.GET)
	public String getLibri(Model model) {
		List<Libro> libri = service.findAll();
		model.addAttribute("libri", libri);
		return "libri";
	}
	
	@RequestMapping(value = "/libriAdmin", method = RequestMethod.GET)
	public String getLibriAdmin(Model model) {
		List<Libro> libri = service.findAll();
		model.addAttribute("libri", libri);
		return "libriAdmin";
	}
	
	@GetMapping("/libro/{id}")
	public String getLibro(@PathVariable("id") Long id, Model model) {
		Libro libro = service.findById(id);
		model.addAttribute("libro", libro);
		return "libro.html";
	}
	
	@GetMapping("/toUpdateLibro")
	public String toUpdateLibro(Model model) {
		return "toUpdateLibro.html";
	}
	
	@GetMapping("/toDeleteLibro/{id}")
	public String toDeleteLibro(@PathVariable("id") Long id, Model model) {
		Libro libro = service.findById(id);
		model.addAttribute("libro", libro);
		return "toDeleteLibro.html";
	}
	
	@Transactional
	@GetMapping("/deleteLibro/{id}")
	public String deleteLibro(@PathVariable("id") Long id, Model model) {
		this.service.delete(id);
		List<Libro> libri = service.findAll();
		model.addAttribute("libri", libri);
		return "libri.html";
	}
	
}
