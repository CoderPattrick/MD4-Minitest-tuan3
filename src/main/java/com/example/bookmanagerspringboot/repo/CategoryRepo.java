package com.example.bookmanagerspringboot.repo;

import com.example.bookmanagerspringboot.model.book.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends PagingAndSortingRepository<Category,Long> {
}
