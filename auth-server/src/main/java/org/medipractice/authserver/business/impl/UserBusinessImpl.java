package org.medipractice.authserver.business.impl;

import org.medipractice.authserver.model.User;
import org.medipractice.authserver.repository.UserRepository;
import org.medipractice.authserver.business.UserBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusinessImpl implements UserBusiness {

    private final UserRepository userRepository;

    @Autowired
    public UserBusinessImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
