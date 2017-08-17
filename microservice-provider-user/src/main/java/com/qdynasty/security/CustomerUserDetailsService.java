/**
 * 
 */
package com.qdynasty.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author fei.qin
 *
 */
@Component
public class CustomerUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("user".equals(username)) {
			return new SecurityUser("user", "password1", "user-role");
		} else if ("admin".equals(username)) {
			return new SecurityUser("admin", "password2", "admin-role");
		} else {
			return null;
		}
	}

}
