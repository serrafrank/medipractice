package org.medipractice.authserver.business.impl;

import org.medipractice.authserver.business.contract.UserTokenBusiness;
import org.medipractice.authserver.model.UserToken;
import org.medipractice.authserver.repository.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service(value = "userTokenBusiness")
public class UserTokenBusinessImpl implements UserTokenBusiness, UserDetailsService {

	private final UserTokenRepository userTokenRepository;

	@Autowired
	public UserTokenBusinessImpl(UserTokenRepository userTokenRepository) {
		this.userTokenRepository = userTokenRepository;
	}


	@Override
    public Optional<UserToken> getByUsername(String username) {
    	return userTokenRepository.findByUsername(username);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserToken user = getByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Invalid username or password.")) ;

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}