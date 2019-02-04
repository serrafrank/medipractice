package org.medipractice.authserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name="user_account")
public class User  implements UserDetails, Serializable {
	@Id
    @GeneratedValue
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private String firstname;
    private String lastname;

    private String email;


    @JsonIgnore
    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @BatchSize(size = 20)
    private Set<Role> roles = new HashSet<>();

    @Transient
    private Set<GrantedAuthority> authorities = new HashSet<>();


    public Set<GrantedAuthority> getAuthorities() {
        authorities = new HashSet<>();
        this.roles.forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getValue())));

        return authorities;
    }

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
