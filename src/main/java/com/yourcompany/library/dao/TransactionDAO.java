package com.yourcompany.library.dao;

import com.yourcompany.library.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    private Connection connection;

    public TransactionDAO() {
        this.connection = DatabaseConnection.initializeDatabase(); // Assume a method for DB connection initialization
    }

    public List<Transaction> findAll() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                transactions.add(new Transaction(
                        rs.getInt("id"),
                        rs.getInt("book_id"),
                        rs.getInt("user_id"),
                        rs.getDate("checkout_date"),
                        rs.getDate("return_date")
                ));
            }
        }
        return transactions;
    }

    public Transaction findById(int id) throws SQLException {
        String sql = "SELECT * FROM transactions WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Transaction(
                            rs.getInt("id"),
                            rs.getInt("book_id"),
                            rs.getInt("user_id"),
                            rs.getDate("checkout_date"),
                            rs.getDate("return_date")
                    );
                }
            }
        }
        return null;
    }

    public boolean insert(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (book_id, user_id, checkout_date, return_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, transaction.getBookId());
            pstmt.setInt(2, transaction.getUserId());
            pstmt.setDate(3, transaction.getCheckoutDate());
            pstmt.setDate(4, transaction.getReturnDate());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean update(Transaction transaction) throws SQLException {
        String sql = "UPDATE transactions SET book_id = ?, user_id = ?, checkout_date = ?, return_date = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, transaction.getBookId());
            pstmt.setInt(2, transaction.getUserId());
            pstmt.setDate(3, transaction.getCheckoutDate());
            pstmt.setDate(4, transaction.getReturnDate());
            pstmt.setInt(5, transaction.getId());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM transactions WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }
}
