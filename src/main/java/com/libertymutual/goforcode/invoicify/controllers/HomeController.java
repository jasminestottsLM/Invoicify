package com.libertymutual.goforcode.invoicify.controllers;

import javax.validation.ConstraintViolationException;

import org.postgresql.util.PSQLException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.invoicify.models.User;
import com.libertymutual.goforcode.invoicify.repositories.UserRepository;

@Controller
@RequestMapping("/")
public class HomeController {

	private UserRepository userRepo;
	private PasswordEncoder encoder;
	
	public HomeController(UserRepository userRepo, PasswordEncoder encoder) {
		this.userRepo = userRepo;
		this.encoder = encoder;
	}
	
	@GetMapping("")
	public String showDefault() {
		return "home/default";
	}
	
	@GetMapping("signup")
	public ModelAndView showSignup() {
		ModelAndView mv = new ModelAndView("home/signup");
		return mv;
	}
	
	@PostMapping("signup")
	public ModelAndView handleSignup(User user) {
		// TODO This is really dumb; needs refactoring
		String password = user.getPassword();
		String encryptedPassword = encoder.encode(password);
		ModelAndView mv = new ModelAndView();
		user.setPassword(encryptedPassword);
		
		try {
			userRepo.save(user);
			mv.setViewName("redirect:/login");
		} catch (DataIntegrityViolationException dive) {
			mv.setViewName("home/signup");
			mv.addObject("errorMessage", "This username is already in use.  Please choose a new username.");
		}
			
		return mv;
	}
}