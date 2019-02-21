package aspire.tech.web.test.service;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceTest {

	/*
	 * We got this encrypted method from the same as BCryptPasswordEncoder
	 * we used inside the UserDetailsService
	 * 
	 * Must add 'ROLE_USER' to the database in the authority table for the user can 
	 * enter the login to see the /dashboard inside our application
	 */
	
	@Test
	public void generateEncyrptedPassword() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "Password123";
		String encodedPassword = encoder.encode(rawPassword);
				
		System.out.println(encodedPassword);
		
		assertThat(rawPassword, not(encodedPassword));
	}

}
