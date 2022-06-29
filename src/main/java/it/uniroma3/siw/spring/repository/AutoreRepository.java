package it.uniroma3.siw.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long> {
	
	public boolean existsByNomeAndCognomeAndAnnoNascita(String nome, String cognome, Integer annoNascita);
	
	public void deleteById(Long id);
	
}