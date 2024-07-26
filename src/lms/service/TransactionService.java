package lms.service;

import lms.entity.Transaction;

import java.util.List;
import java.util.Map;

public interface TransactionService {
    void borrowBook(String userID, String bookID);

    void returnBook(String userID, String bookID);

    List<Transaction> getUserTransactions(String userID);

    List<Transaction> getAllTransactions();

}
