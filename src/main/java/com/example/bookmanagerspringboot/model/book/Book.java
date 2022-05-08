package com.example.bookmanagerspringboot.model.book;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String description;
    private String image;
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Book(String author, String description, String image, String name, Category category) {
        this.author = author;
        this.description = description;
        this.image = image;
        this.name = name;
        this.category = category;
    }

    public Book(Long id, String author, String description, String image, String name, Category category) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.image = image;
        this.name = name;
        this.category = category;
    }

    public Book() {
    }
}
