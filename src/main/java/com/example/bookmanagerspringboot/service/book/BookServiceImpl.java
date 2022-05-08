package com.example.bookmanagerspringboot.service.book;

import com.example.bookmanagerspringboot.model.book.Book;
import com.example.bookmanagerspringboot.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepo bookRepo;

    @Override
    public Iterable<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void save(Long id, Book book) {
        book.setId(id);
        bookRepo.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
}
