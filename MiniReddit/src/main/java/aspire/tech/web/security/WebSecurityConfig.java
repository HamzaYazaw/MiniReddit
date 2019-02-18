package aspire.tech.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean												//Allows you to use the 'PasswordEncoder' in any other file. 
	public PasswordEncoder getPasswordEncoder() {		//This returns an object of the password 
		return new BCryptPasswordEncoder();				//new instance from 'BCryptPasswordEncoder'. 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.passwordEncoder(getPasswordEncoder())
				.withUser("Hamza")
				.password(getPasswordEncoder().encode("123"))
				.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				   .antMatchers("/").permitAll()			//Can't access /dashboard because of the permits
				   .anyRequest().hasRole("USER").and()
			.formLogin()
				   .loginPage("/login")
				   .permitAll()
				   .and()
			.logout()
				   .logoutUrl("/logout")
				   .permitAll();
	}
}
