package aspire.tech.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;

	
	/*
	 * Allows you to use the 'PasswordEncoder' in any other file.
	 * This returns an object of the password
	 * new instance from 'BCryptPasswordEncoder'.
	 */
	
	@Bean												
	public PasswordEncoder getPasswordEncoder() {		
		return new BCryptPasswordEncoder();				 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(getPasswordEncoder());
			
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		.csrf().disable()
		http.authorizeRequests()
				   .antMatchers("/").permitAll()			//Can't access /dashboard because of the permits
				   .antMatchers("/register").permitAll()
				   .antMatchers("/admin/**").hasRole("ADMIN")
				   .anyRequest().hasRole("USER").and()
			.formLogin()
				   .loginPage("/login")
				   .defaultSuccessUrl("/dashboard")
				   .permitAll()
				   .and()
			.logout()
				   .logoutUrl("/logout")
				   .permitAll();
	}
}
