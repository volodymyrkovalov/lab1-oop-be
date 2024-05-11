package com.yourcompany.library.model;

import java.sql.Date;

/**
 * Represents a Transaction entity in the database, tracking book loans.
 */
public class Transaction {
    private int id;
    private int bookId;
    private int userId;
    private Date checkoutDate;
    private Date returnDate;

    // Default constructor
    public Transaction() {
    }

    // Constructor with parameters
    public Transaction(int id, int bookId, int userId, Date checkoutDate, Date returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    // ToString method for debugging and logging purposes
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", checkoutDate=" + checkoutDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
