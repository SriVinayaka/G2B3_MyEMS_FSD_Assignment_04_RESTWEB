/**
 * 
 */
package com.gl.myemsapp.security.entity.service.implementation;

/**
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.myemsapp.security.entity.MyEmsAppUserDetails;
import com.gl.myemsapp.security.entity.User;
import com.gl.myemsapp.security.repository.UserRepository;

public class MyEmsAppUserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new MyEmsAppUserDetails(user);
	}
}