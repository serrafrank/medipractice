package org.medipractice.authserver.config;

import org.medipractice.authserver.model.Role;
import org.medipractice.authserver.model.User;
import org.medipractice.authserver.business.UserRoleService;
import org.medipractice.authserver.business.UserBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserBusiness userBusiness;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userBusiness.findByUsername(username);

        if(user == null){
             throw new UsernameNotFoundException("用户名："+ username + "不存在！");
        }
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        Iterator<Role> iterator =  user.getList().iterator();
        while (iterator.hasNext()){
            collection.add(new SimpleGrantedAuthority(iterator.next().getRole_name()));
        }

        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),collection);
    }
}
