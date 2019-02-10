package org.medipractice.authserver.business.impl;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.authserver.business.UserBusiness;
import org.medipractice.authserver.model.User;
import org.medipractice.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Slf4j
@Service
public class UserBusinessImpl implements UserBusiness {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        User existing = userRepository.findByUsername(user.getUsername());
        Assert.isNull(existing, "user already exists: " + user.getUsername());

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
        log.info("new user has been created: {}", user.getUsername());
    }
}
