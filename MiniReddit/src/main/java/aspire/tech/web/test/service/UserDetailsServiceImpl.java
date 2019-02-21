package aspire.tech.web.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aspire.tech.web.security.CustomSecurityUser;
import aspire.tech.web.test.entites.User;
import aspire.tech.web.test.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {		//UserDetailsService is an interface

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		//This method is overidden 
		User user = userRepository.findByUsername(username);
		
		if (user==null) {
			throw new UsernameNotFoundException("Invalid username and password");
		}
		return new CustomSecurityUser(user);
	}

}
