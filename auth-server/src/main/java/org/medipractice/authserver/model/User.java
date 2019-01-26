package org.medipractice.authserver.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    private String username;
    
    private String password;

    private boolean active;

}
