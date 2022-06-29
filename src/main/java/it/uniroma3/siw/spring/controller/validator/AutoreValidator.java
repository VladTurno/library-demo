package it.uniroma3.siw.spring.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Autore;
import it.uniroma3.siw.spring.service.AutoreService;

@Component
public class AutoreValidator implements Validator {
	
	@Autowired 
	private AutoreService autoreService;
	
	@Override
	public boolean supports(Class<?> Class) {
		return Autore.class.equals(Class);
	}

	@Override
	public void validate(Object o, Errors errors) {
		if(autoreService.alreadyExists((Autore) o)) {
			errors.reject("autore.duplicato");
		}
		Autore a = (Autore) o;
		if(a.getNome()==null) {
			errors.reject("autore.noNome");
		}
	}

}
