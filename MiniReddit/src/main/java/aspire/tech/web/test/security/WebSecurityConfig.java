package aspire.tech.web.test.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration		//Java folder of an XML file
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()		//This allows one user to enter
			.withUser("Hamza")				//This gives the user name
			.password("123")				//This gives the password
			.roles("USER");					//Gives role to the user as in 'USER'
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/")			//This allows everyone to only see the home page
			.permitAll()				//This is allowing everyone to enter and only see the home page
			.anyRequest()				//Gives that the next Role can access all the other requests
			.hasRole("USER")
			.and()
				.formLogin()				//Gives everyone the privilege to enter the login page
				.loginPage("/login")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/logout")
				.permitAll();
	}
}
