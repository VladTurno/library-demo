package it.uniroma3.siw.spring.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Editore;
import it.uniroma3.siw.spring.service.EditoreService;

@Component
public class EditoreValidator implements Validator {
	
	@Autowired 
	private EditoreService editoreService;
	
	@Override
	public boolean supports(Class<?> Class) {
		return Editore.class.equals(Class);
	}

	@Override
	public void validate(Object o, Errors errors) {
		if(editoreService.alreadyExists((Editore) o)) {
			errors.reject("editore.duplicato");
		}
	}

}
