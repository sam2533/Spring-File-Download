package com.um.myapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.um.myapp.model.User;

public class UserFormValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object obj, Errors error) {
		User user = (User) obj;
		
		if(user.getPhone() == null){
			error.rejectValue("phone", "Diff.userForm.phone");
		}
		if(!user.getPassword().equals(user.getConfirmPassword())){
			error.rejectValue("confirmPassword"	, "Diff.username.confirmPassword");
		}	
	}
	public boolean isValid(Object obj){
		User user = (User) obj;
		// Validating phone number with the 10 digit numbers
		if(user.getPhone().matches("\\d{10}")) return true;
		//validating phone number with -,.,spaces 
		if(user.getPhone().matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
		//validating phone number with extention of 5 & 5
		if(user.getPhone().matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
		//then return false if nothing matches
		return false;
		
	}
}
