package org.medipractice.authserver.dao;


import org.medipractice.authserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();
    
    User getById(Integer id);
    
    User getByUsername(String username);
}
