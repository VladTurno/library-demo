package it.uniroma3.siw.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Autore;
import it.uniroma3.siw.spring.model.Editore;
import it.uniroma3.siw.spring.model.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long> {
	
	public boolean existsByTitoloAndAutoreAndEditore(String titolo, Autore autore, Editore editore);
	
	public void deleteById(Long id);
	
}