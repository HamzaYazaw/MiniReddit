package aspire.tech.web.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import aspire.tech.web.test.entites.Authority;
import aspire.tech.web.test.entites.User;
import aspire.tech.web.test.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * This save method saves a User into the database
	 */
	
	public User save(User user)  {

		
		
		/*
		 * This encodes the password first
		 */
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword); 
		
		/*
		 * Give roles to the user
		 */
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setUser(user);
		user.getAuthorities().add(authority);
		
		return userRepo.save(user);
		
	}
}
