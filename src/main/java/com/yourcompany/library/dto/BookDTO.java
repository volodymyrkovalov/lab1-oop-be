package com.yourcompany.library.dto;

/**
 * Book Data Transfer Object to encapsulate book data.
 */
public class BookDTO {
    private int id;
    private String title;
    private String author;

    // Default constructor
    public BookDTO() {
    }

    // Constructor with parameters
    public BookDTO(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // ToString method for debugging and logging purposes
    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
