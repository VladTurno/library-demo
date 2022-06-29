package it.uniroma3.siw.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Editore;

public interface EditoreRepository extends CrudRepository<Editore, Long> {
	
	public boolean existsByNomeAndAnnoFondazioneAndPaese(String nome, Integer annoFondazione, String paese);
	
	public void deleteById(Long id);
	
}