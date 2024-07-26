package lms.service;

import lms.entity.Book;

import java.util.List;
public interface BookService {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);
     Book searchBooks(String query);
    Book searchBookById(String bookID);
    Book searchBookByTitle(String title);
    Book searchBookByAuthor(String Author);

    List<Book> getAvailableBooksList();
    List<Book> getBorrowedBooksList();
}
