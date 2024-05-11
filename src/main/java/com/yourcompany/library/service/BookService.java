package com.yourcompany.library.service;

import com.yourcompany.library.dao.BookDAO;
import com.yourcompany.library.dto.BookDTO;
import com.yourcompany.library.mapper.BookMapper;
import com.yourcompany.library.model.Book;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing books in the library.
 */
public class BookService {
    private BookDAO bookDAO;
    private BookMapper bookMapper;

    public BookService() {
        this.bookDAO = new BookDAO();
        this.bookMapper = new BookMapper();
    }

    /**
     * Retrieves all books from the library.
     * @return A list of BookDTO objects.
     */
    public List<BookDTO> findAllBooks() {
        try {
            List<Book> books = bookDAO.findAll();
            return books.stream().map(bookMapper::toDto).collect(Collectors.toList());
        } catch (Exception e) {
            // Ideally, you'd handle exceptions more gracefully
            throw new RuntimeException("Failed to retrieve books", e);
        }
    }

    /**
     * Adds a new book to the library.
     * @param bookDTO The BookDTO object containing the book details.
     * @return true if the book was successfully added, false otherwise.
     */
    public boolean addBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        try {
            return bookDAO.insert(book);
        } catch (Exception e) {
            // Log and handle exceptions appropriately
            throw new RuntimeException("Failed to add book", e);
        }
    }

    /**
     * Updates an existing book's information.
     * @param bookDTO The BookDTO with updated information.
     * @return true if the book was successfully updated, false otherwise.
     */
    public boolean updateBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        try {
            return bookDAO.update(book);
        } catch (Exception e) {
            // Log and handle exceptions appropriately
            throw new RuntimeException("Failed to update book", e);
        }
    }

    /**
     * Deletes a book from the library.
     * @param id The ID of the book to delete.
     * @return true if the book was successfully deleted, false otherwise.
     */
    public boolean deleteBook(int id) {
        try {
            return bookDAO.delete(id);
        } catch (Exception e) {
            // Log and handle exceptions appropriately
            throw new RuntimeException("Failed to delete book", e);
        }
    }
}
