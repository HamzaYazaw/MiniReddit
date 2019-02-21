package aspire.tech.web.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import aspire.tech.web.test.entites.User;
import aspire.tech.web.test.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
	
	/*
	 * We are adding ModelMap because we need to inject User object into our register
	 * so it knows that we can use it within 
	 * With the use of model.put("user") it will now search for the 'user' object within the HTML register
	 */
	
	@GetMapping(value = "/register")
	public String register(ModelMap model) {
		model.put("user", new User());
		return "register";
	}
	
	/*
	 * Redirecting is used because we are using POST method inside our register HTML
	 * and by that we are avoiding the problem of the refresh duplicate data
	 */
	
	@PostMapping("/register")
	public String registerPost(User user) {
		userService.save(user);
		return "redirect:/login";
	}
}
