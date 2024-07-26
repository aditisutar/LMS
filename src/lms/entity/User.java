package lms.entity;

public interface User {
    void borrowBook(Book book);
    void returnBook(Book book);
    void reserveBook(Book book);


}
