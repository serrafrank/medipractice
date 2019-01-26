package org.medipractice.authserver.business.impl;

import org.medipractice.authserver.business.UserBusiness;
import org.medipractice.authserver.dao.UserRepository;
import org.medipractice.authserver.exception.ResourceNotFoundException;
import org.medipractice.authserver.model.User;
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
public class UserBusinessImpl implements UserBusiness, UserDetailsService {

	@Autowired
	protected UserRepository userRepository;

    @Override
    public List<User> findAll() {
    	return userRepository.findAll();
    }

	@Override
	public void update(User update) {
    	if(update.getId() != null && userRepository.getById(update.getId()) != null ){
			userRepository.save(update);
		}else{
			throw new ResourceNotFoundException("Resource not found with id : " + update.getId());
		}

	}

	@Override
	public User save(User update) {
		return userRepository.save(update);
	}

	@Override
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
    public User getById(Integer id) {
    	return Optional
    			.ofNullable(userRepository.getById(id))
    			.orElseThrow(() -> new ResourceNotFoundException("Resource not found with id : " + id));
    }
    
    @Override
    public User getByUsername(String username) {
    	return Optional
    			.ofNullable(userRepository.getByUsername(username))
    			.orElseThrow(() -> new ResourceNotFoundException("Resource not found with username : " + username));
    }
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}