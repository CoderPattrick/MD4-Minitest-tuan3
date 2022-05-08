package com.example.bookmanagerspringboot.service.user;

import com.example.bookmanagerspringboot.model.user.AppUser;
import com.example.bookmanagerspringboot.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Iterable<AppUser> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void save(AppUser appUser) {
        userRepo.save(appUser);
    }

    @Override
    public void save(Long id, AppUser appUser) {
        appUser.setId(id);
        userRepo.save(appUser);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepo.findByAccount(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(appUser.getRole());
        UserDetails userDetails = new User(
                appUser.getAccount(),
                appUser.getPassword(),
                authorities
        );
        return userDetails;
    }
}
