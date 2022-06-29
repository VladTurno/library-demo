package it.uniroma3.siw.spring.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Libro;
import it.uniroma3.siw.spring.service.LibroService;

@Component
public class LibroValidator implements Validator {
	
	@Autowired 
	private LibroService libroService;
	
	@Override
	public boolean supports(Class<?> Class) {
		return Libro.class.equals(Class);
	}

	@Override
	public void validate(Object o, Errors errors) {
		if(libroService.alreadyExists((Libro) o)) {
			errors.reject("libro.duplicato");
		}
		Libro libro = (Libro) o;
		if(libro.getAutore()==null) {
			errors.reject("libro.noAutore");
		}
		if(libro.getEditore()==null) {
			errors.reject("libro.noEditore");
		}
	}

}
