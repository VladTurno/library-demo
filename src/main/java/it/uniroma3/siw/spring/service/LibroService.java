package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Autore;
import it.uniroma3.siw.spring.model.Editore;
import it.uniroma3.siw.spring.model.Libro;
import it.uniroma3.siw.spring.repository.LibroRepository;

@Service
public class LibroService {
	
	@Autowired
	private LibroRepository repository;

	@Transactional
	public void save(Libro l) {
		repository.save(l);
	}
	
	@Transactional
	public void update(Libro l) {
		repository.save(l);
	}
	
	@Transactional
	public void delete(Libro l) {
		repository.delete(l);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Libro findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Libro> findAll() {
		List<Libro> libri = new ArrayList<Libro>();
		for(Libro l : repository.findAll())
			libri.add(l);
		return libri;
	}
	
	public List<Libro> findByAutore(Autore autore) {
		List<Libro> libri = new ArrayList<Libro>();
		for(Libro l : repository.findAll()) 
			if (l.getAutore().equals(autore)) 
				libri.add(l);
		return libri;
	}
	
	public List<Libro> findByEditore(Editore editore) {
		List<Libro> libri = new ArrayList<Libro>();
		for(Libro l : repository.findAll()) 
			if (l.getEditore().equals(editore)) 
				libri.add(l);
		return libri;
	}
	
	public boolean alreadyExists(Libro l) {
		return repository.existsByTitoloAndAutoreAndEditore(l.getTitolo(), l.getAutore(), l.getEditore());
	}
	
}
