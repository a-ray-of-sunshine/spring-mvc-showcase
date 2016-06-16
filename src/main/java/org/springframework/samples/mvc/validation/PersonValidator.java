package org.springframework.samples.mvc.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Person.class.equals(paramClass);
	}

	@Override
	public void validate(Object paramObject, Errors paramErrors) {
		ValidationUtils.rejectIfEmpty(paramErrors, "name", "name.empty");
		Person p = (Person) paramObject;
		if(p.getAge() < 0){
			paramErrors.rejectValue("age", "negativevalue");
		}else if(p.getAge() > 110){
			paramErrors.rejectValue("age", "too.darn.old");
		}
	}

}
