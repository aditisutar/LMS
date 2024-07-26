package lms.service;

import lms.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.logging.Logger;



public class TransactionServiceImpl implements TransactionService {
    private static final Logger LOGGER = Logger.getLogger(TransactionServiceImpl.class.getName());
    private List<Transaction> transactions = new ArrayList<>();
    private BookService bookService;
    private UserService userService;

    public TransactionServiceImpl(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @Override
    public void borrowBook(String userID, String bookID) {
        User user = userService.getUser(userID);
        Book book = bookService.searchBookById(bookID);
        if (book.isAvailable()) {
            book.borrow();
            Transaction transaction = new Transaction(
                    String.valueOf(transactions.size() + 1), bookID, userID, new Date(), new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000));
            transaction.initiateTransaction();
            transactions.add(transaction);
            LOGGER.info("Book borrowed: " + book.getTitle() + " by User: " + ((Member) user).getName());
        } else {
            throw new IllegalStateException("Book is not available for borrowing.");
        }
    }

    @Override
    public void returnBook(String userID, String bookID) {
        User user = userService.getUser(userID);
        Book book = bookService.searchBookById(bookID);
        Transaction transaction = transactions.stream()
                .filter(t -> t.getBookID().equals(bookID) && t.getUserID().equals(userID) && t.getStatus() == Transaction.TransactionStatus.ACTIVE)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No active transaction found for this book and user."));
        book.returnBook();
        transaction.completeTransaction();
        LOGGER.info("Book returned: " + book.getTitle() + " by User: " + ((Member) user).getName());
    }

    @Override
    public List<Transaction> getUserTransactions(String userID) {
        return transactions.stream()
                .filter(t -> t.getUserID().equals(userID))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactions;
    }


}

