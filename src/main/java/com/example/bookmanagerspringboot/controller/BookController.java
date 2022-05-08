package com.example.bookmanagerspringboot.controller;

import com.example.bookmanagerspringboot.model.book.Book;
import com.example.bookmanagerspringboot.model.book.Category;
import com.example.bookmanagerspringboot.service.book.BookService;
import com.example.bookmanagerspringboot.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
public class BookController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;
    @ModelAttribute("categories")
    public Iterable<Category> findAllCate(){
        return categoryService.findAll();
    }
    @GetMapping
    public ResponseEntity<Iterable<Book>> findAllBook(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.findById(id).get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity createBook(@RequestBody Book book){
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity editBook(@PathVariable Long id, @RequestBody Book book){
        bookService.save(id,book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
