package aspire.tech.web.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import aspire.tech.web.test.entites.Authority;
import aspire.tech.web.test.entites.User;

/*
 * We have added this Custom to make the coupling losely and not tight
 * We extended from our 'User' to not duplicate the password and username methods
 */

public class CustomSecurityUser extends User implements UserDetails{	
																					
	/**
	 * Because it's implemeted from 'UserDetails' which is extended from 'Serializable'
	 */
	private static final long serialVersionUID = -3937114915983953837L;
	
	public CustomSecurityUser() {
		
	}
	
	public CustomSecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}

	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	/*
	 * The next couple of methods should be in the DB
	 * As values, if one of them return 'false' then it shouldn't allow them inside
	 * of the database because it's false
	 */
	
	@Override
	public boolean isAccountNonExpired() {		
		return true;							
	}											

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
