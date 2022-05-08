package com.example.bookmanagerspringboot.repo;

import com.example.bookmanagerspringboot.model.book.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends PagingAndSortingRepository<Book,Long> {
}
