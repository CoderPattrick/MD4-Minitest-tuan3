package com.example.bookmanagerspringboot.service;

import java.util.Optional;

public interface GeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void save(Long id, T t);
    void delete(Long id);
}
