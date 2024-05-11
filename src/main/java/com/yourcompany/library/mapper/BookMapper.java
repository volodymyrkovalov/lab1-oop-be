package com.yourcompany.library.mapper;

import com.yourcompany.library.dto.BookDTO;
import com.yourcompany.library.model.Book;

/**
 * Mapper for converting between Book entity and BookDTO.
 */
public class BookMapper {

    /**
     * Converts a Book entity to a BookDTO.
     * @param book The Book entity.
     * @return The corresponding BookDTO.
     */
    public BookDTO toDto(Book book) {
        if (book == null) {
            return null;
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        return bookDTO;
    }

    /**
     * Converts a BookDTO to a Book entity.
     * @param bookDTO The BookDTO.
     * @return The corresponding Book entity.
     */
    public Book toEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        return book;
    }
}
