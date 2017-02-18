
/*
package com.um.myapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone,String> {
	
	public void initialize(Phone arg0) {		
	}

	@Override
	public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
		if(phoneNo == null){
			return false;
		}
		// Validating phone number with the 10 digit numbers
		if(phoneNo.matches("\\d{10}")) return true;
		//validating phone number with -,.,spaces 
		if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
		//validating phone number with extention of 5 & 5
		if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
		//then return false if nothing matches
		return false;
	}

}
*/
