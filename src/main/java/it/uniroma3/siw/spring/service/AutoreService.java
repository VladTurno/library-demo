package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Autore;
import it.uniroma3.siw.spring.model.Libro;
import it.uniroma3.siw.spring.repository.AutoreRepository;

@Service
public class AutoreService {
	
	@Autowired
	private AutoreRepository repository;
	
	@Autowired
	private LibroService service;


	@Transactional
	public void save(Autore a) {
		repository.save(a);
	}
	
	@Transactional
	public void update(Autore a) {
		repository.save(a);
	}
	
	@Transactional
	public void delete(Autore a) {
		repository.delete(a);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Autore findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Autore> findAll() {
		List<Autore> autori = new ArrayList<Autore>();
		for(Autore a : repository.findAll())
			autori.add(a);
		return autori;
	}
	
	public List<Libro> findAllLibri(Autore a) {
		List<Libro> libri = new ArrayList<Libro>();
		libri = service.findByAutore(a);
		return libri;
	}
	
	public boolean alreadyExists(Autore a) {
		return repository.existsByNomeAndCognomeAndAnnoNascita(a.getNome(), a.getCognome(), a.getAnnoNascita());
	}
	
}
