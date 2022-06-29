package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Editore;
import it.uniroma3.siw.spring.model.Libro;
import it.uniroma3.siw.spring.repository.EditoreRepository;

@Service
public class EditoreService {
	
	@Autowired
	private EditoreRepository repository;
	
	@Autowired
	private LibroService service;

	@Transactional
	public void save(Editore e) {
		repository.save(e);
	}
	
	@Transactional
	public void delete(Editore e) {
		repository.delete(e);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Editore findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Editore> findAll() {
		List<Editore> editori = new ArrayList<Editore>();
		for(Editore e : repository.findAll())
			editori.add(e);
		return editori;
	}
	
	public List<Libro> findAllLibri(Editore e) {
		List<Libro> libri = new ArrayList<Libro>();
		libri = service.findByEditore(e);
		return libri;
	}
	
	public boolean alreadyExists(Editore e) {
		return repository.existsByNomeAndAnnoFondazioneAndPaese(e.getNome(), e.getAnnoFondazione(), e.getPaese());
	}
	
}
