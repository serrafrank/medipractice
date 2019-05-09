package org.medipractice.authserver.business.impl;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.authserver.business.UserAccountBusiness;
import org.medipractice.authserver.model.UserAccount;
import org.medipractice.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service("userAccountBusiness")
public class UserAccountBusinessImpl implements UserAccountBusiness, UserDetailsService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserAccount userAccount) throws Exception {
        if(userRepository.findByUsername(userAccount.getUsername()).isPresent())
            throw new Exception("Username already exists: " + userAccount.getUsername());

        String hash = encoder.encode(userAccount.getPassword());
        userAccount.setPassword(hash);
        userRepository.save(userAccount);
        log.info("new userAccount has been created: {}", userAccount.getUsername());
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return findByUsername(username);
    }
}
