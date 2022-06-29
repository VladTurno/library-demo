package it.uniroma3.siw.spring.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.siw.spring.controller.validator.AutoreValidator;
import it.uniroma3.siw.spring.model.Autore;
import it.uniroma3.siw.spring.model.Libro;
import it.uniroma3.siw.spring.service.AutoreService;

@Controller
public class AutoreController {

	@Autowired
	private AutoreService service;
	
	@Autowired
	private AutoreValidator validator;
	
	@RequestMapping(value="/autore", method = RequestMethod.GET)
	public String getAutore(Model model) {
		model.addAttribute("autore", new Autore());
		return "autoreForm.html";
	}
	
	@RequestMapping(value = "/autore", method = RequestMethod.POST)
	public String addAutore(@ModelAttribute("autore") Autore autore, BindingResult binding, Model model) {
		validator.validate(autore, binding);
		if(!binding.hasErrors()) {
			service.save(autore);
			model.addAttribute("autori", service.findAll());
			return "autoriAdmin.html";
		}
		else return "autoreForm.html";
	}
	
	@GetMapping("/autori")
	public String getAutori(Model model) {
		List<Autore> autori = service.findAll();
		model.addAttribute("autori", autori);
		return "autori.html";
	}
	
	@GetMapping("/autoriAdmin")
	public String getAutoriAdmin(Model model) {
		List<Autore> autori = service.findAll();
		model.addAttribute("autori", autori);
		return "autoriAdmin.html";
	}
	
	@GetMapping("/autore/{id}")
	public String getAutore(@PathVariable("id") Long id, Model model) {
		Autore autore = service.findById(id);
		model.addAttribute("autore", autore);
		List<Libro> libri = service.findAllLibri(autore);
		model.addAttribute("libri", libri);
		return "autore.html";
	}
	
	@GetMapping("/toUpdateAutore/{id}")
	public String toUpdateAutore(@PathVariable("id") Long id, Model model) {
		Autore autore = service.findById(id);
		model.addAttribute("autore", autore);
		return "toUpdateAutore.html";
	}
	
	@Transactional
	@PostMapping("/updateAutore")
	public String updateAutore(@ModelAttribute("autore") Autore autore, Model model, BindingResult binding) {
		validator.validate(autore, binding);
		if(!binding.hasErrors()) {
			service.update(autore);
			model.addAttribute("autore", service.findById(autore.getId()));
			return "autore.html";
		}
		else return "updateAutore.html";
	}
	
	@GetMapping("/toDeleteAutore/{id}")
	public String toDeleteAutore(@PathVariable("id") Long id, Model model) {
		Autore autore = service.findById(id);
		model.addAttribute("autore", autore);
		return "toDeleteAutore.html";
	}
	
	@Transactional
	@GetMapping("/deleteAutore/{id}")
	public String deleteAutore(@PathVariable("id") Long id, Model model) {
		this.service.delete(id);
		List<Autore> autori = service.findAll();
		model.addAttribute("autori", autori);
		return "autoriAdmin.html";
	}
	
}
