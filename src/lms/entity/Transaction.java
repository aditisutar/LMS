package lms.entity;

import java.util.Date;

public class Transaction {
    private String transactionID;
    private String bookID;
    private String userID;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private TransactionStatus status;

    public Transaction(String transactionID, String bookID, String userID, Date borrowDate, Date dueDate) {
        this.transactionID = transactionID;
        this.bookID = bookID;
        this.userID = userID;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.status = TransactionStatus.ACTIVE;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getBookID() {
        return bookID;
    }

    public String getUserID() {
        return userID;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void initiateTransaction() {
        this.status = TransactionStatus.ACTIVE;
    }

    public void completeTransaction() {
        this.returnDate = new Date();
        this.status = TransactionStatus.COMPLETED;
    }

    public enum TransactionStatus {
        ACTIVE,
        COMPLETED
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID='" + transactionID + '\'' +
                ", bookID='" + bookID + '\'' +
                ", userID='" + userID + '\'' +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", status=" + status +
                '}';
    }
}

