package com.um.myapp;


import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.um.myapp.model.User;
import com.um.myapp.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@Autowired
	@Qualifier(value="userService")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//list Users Pages
	@RequestMapping(value = {"/", "/users"}, method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Home Page and User lists Page");	
		List<User> users = this.userService.findAll();
		model.addAttribute("users", users);
		return "list";
	}
	// User registration form
    @RequestMapping(value =  "/add", method = RequestMethod.GET)
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("userForm", user);
        return "userForm";
    }
	//save or update user info
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveorUpdateUser(@ModelAttribute("userForm") @Valid User user, BindingResult result, Model model, RedirectAttributes redirect){
		logger.info("Save or Update user info");
		
		if(result.hasErrors()){
			logger.info("Return Back to user form page");
			return "userForm";
		}else{
			redirect.addFlashAttribute("css", "success");
			if(user.isNew()){
				redirect.addFlashAttribute("msg", "User Saved Successfully");
			}
			else{
				redirect.addFlashAttribute("msg", "User Update Successfully");
			}
			this.userService.saveOrUpdate(user);
		}
		 model.addAttribute("success", "Employee " + user.getName() + " registered successfully");
		// POST/REDIRECT/GET
		return "success" + user.getId();
	}
	
	//Update User info
	@RequestMapping(value="/{id}/update", method=RequestMethod.GET)
	public String updateUserForm(@PathVariable("id") int id, Model model){
		logger.info("Update form is here....", id);
		User user = this.userService.findById(id);
		model.addAttribute("userForm", user);
		return "userForm";	
	}
	//Delete the user info
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public String removeUser(@PathVariable("id") int id, final RedirectAttributes redirect){
		logger.debug("Delete User: ", id);
		this.userService.delete(id);
		redirect.addFlashAttribute("css", "success");
		redirect.addFlashAttribute("msg", "User Successfully deleted");
		return "redirect:/users";
		
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showUser(@PathVariable ("id") int id, Model model){
		logger.debug("Show User id: "+id);
		User user = this.userService.findById(id);
		if(user == null){
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("user", user);
		return "success";
	}
	
}
