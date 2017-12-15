package com.hellokoding.account.model;


import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="uid")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="city")
    private String city;

    @Column(name="uimage")
    private String uimage;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="uid")
    private List<Follow> followings;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fid")
    private List<Follow> followers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="uid")
    private List<Like> likes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="uid")
    private List<Rate> rates;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="uid")
    private List<Playlist> playlists;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="uid")
    private List<Listen> listens;

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
