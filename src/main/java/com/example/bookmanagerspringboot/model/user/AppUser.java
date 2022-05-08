package com.example.bookmanagerspringboot.model.user;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private  AppRole role;

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }

    public AppUser(String account, String password, AppRole role) {
        this.account = account;
        this.password = password;
        this.role = role;
    }

    public AppUser(Long id, String account, String password, AppRole role) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUser(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public AppUser(Long id, String account, String password) {
        this.id = id;
        this.account = account;
        this.password = password;
    }

    public AppUser() {
    }
}
