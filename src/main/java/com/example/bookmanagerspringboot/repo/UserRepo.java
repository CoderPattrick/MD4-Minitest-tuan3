package com.example.bookmanagerspringboot.repo;

import com.example.bookmanagerspringboot.model.user.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends PagingAndSortingRepository<AppUser,Long> {
    public AppUser findByAccount(String account);
}
