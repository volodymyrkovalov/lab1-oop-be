package com.yourcompany.library.controller;

import com.yourcompany.library.dto.BookDTO;
import com.yourcompany.library.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookController extends HttpServlet {

    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equalsIgnoreCase("details")) {
            showBookDetails(req, resp);
        } else {
            listBooks(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addBook(req, resp);
    }

    private void listBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<BookDTO> books = bookService.findAllBooks();
            req.setAttribute("books", books);
            req.getRequestDispatcher("/book-list.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Error retrieving books", e);
        }
    }

    private void showBookDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            BookDTO book = bookService.findBookById(id);
            if (book != null) {
                req.setAttribute("book", book);
                req.getRequestDispatcher("/book-details.jsp").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Book not found");
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid book ID");
        } catch (Exception e) {
            throw new ServletException("Error retrieving book details", e);
        }
    }

    private void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        try {
            BookDTO newBook = new BookDTO();
            newBook.setTitle(title);
            newBook.setAuthor(author);
            bookService.addBook(newBook);
            resp.sendRedirect(req.getContextPath() + "/books");
        } catch (Exception e) {
            throw new ServletException("Error adding book", e);
        }
    }
}