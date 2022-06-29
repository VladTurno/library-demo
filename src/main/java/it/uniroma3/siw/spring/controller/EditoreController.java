package it.uniroma3.siw.spring.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.siw.spring.controller.validator.EditoreValidator;
import it.uniroma3.siw.spring.model.Editore;
import it.uniroma3.siw.spring.model.Libro;
import it.uniroma3.siw.spring.service.EditoreService;

@Controller
public class EditoreController {

	@Autowired
	private EditoreService service;
	
	@Autowired
	private EditoreValidator validator;
	
	@RequestMapping(value="/editore", method = RequestMethod.GET)
	public String getEditore(Model model) {
		model.addAttribute("editore", new Editore());
		return "editoreForm.html";
	}
	
	@PostMapping("/editore")
	public String addEditore(@ModelAttribute("editore") Editore editore, Model model, BindingResult binding) {
		validator.validate(editore, binding);
		if(!binding.hasErrors()) {
			service.save(editore);
			model.addAttribute("editori", service.findAll());
			return "editori.html";
		}
		else return "editoreForm.html";
	}
	
	@GetMapping("/editori")
	public String getEditori(Model model) {
		List<Editore> editori = service.findAll();
		model.addAttribute("editori", editori);
		return "editori.html";
	}
	
	@GetMapping("/editoriAdmin")
	public String getEditoriAdmin(Model model) {
		List<Editore> editori = service.findAll();
		model.addAttribute("editori", editori);
		return "editoriAdmin.html";
	}
	
	@GetMapping("/editore/{id}")
	public String getEditore(@PathVariable("id") Long id, Model model) {
		Editore editore = service.findById(id);
		model.addAttribute("editore", editore);
		List<Libro> libri = service.findAllLibri(editore);
		model.addAttribute("libri", libri);
		return "editore.html";
	}
	
	@GetMapping("/toUpdateEditore")
	public String toUpdateEditore(Model model) {
		return "toUpdateEditore.html";
	}
	
	@GetMapping("/toDeleteEditore/{id}")
	public String toDeleteEditore(@PathVariable("id") Long id, Model model) {
		Editore editore = service.findById(id);
		model.addAttribute("editore", editore);
		return "toDeleteEditore.html";
	}
	
	@Transactional
	@GetMapping("/deleteEditore/{id}")
	public String deleteEditore(@PathVariable("id") Long id, Model model) {
		this.service.delete(id);
		List<Editore> editori = service.findAll();
		model.addAttribute("editori", editori);
		return "editori.html";
	}
	
}
