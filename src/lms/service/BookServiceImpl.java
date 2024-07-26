package lms.service;

import lms.entity.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.stream.Collectors;
import java.util.logging.Logger;



public class BookServiceImpl implements BookService {
    private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class.getName());
    private List<Book> books = new ArrayList<>();


    @Override
    public void addBook(Book book) {
        if(books.contains(book.getBookID())){
            throw new IllegalArgumentException("Book already exists with userId as: "+book.getBookID());
        }
        else {
            books.add(book);
            LOGGER.info("Book added: " + book.getTitle());
        }

    }

    @Override
    public void updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookID().equals(book.getBookID())) {
                books.set(i, book);
                LOGGER.info("Book updated: " + book.getTitle());
                return;
            }
        }
        throw new IllegalArgumentException("Book not found: " + book.getBookID());
    }



    @Override
    public void deleteBook(Book book) {
        if (books.contains(book)){
            books.remove(book);
            LOGGER.info("Book deleted: " + book.getBookID());
        }
        else {
            throw new IllegalArgumentException("Book not found for deletion: "+book.getBookID());

        }

    }

    @Override
    public Book searchBooks(String query) {

        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(query.toLowerCase()) || book.getBookID().contains(query.toLowerCase()))
                .findFirst().orElseThrow(()-> new IllegalArgumentException("Book does not exists"));
    }

    @Override
    public Book searchBookByTitle(String bookTitle) {
        Book book= searchBooks(bookTitle);
        return book;
    }

    @Override
    public Book searchBookByAuthor(String authorName) {
        Book book= searchBooks(authorName);
        return book;
    }



    @Override
    public Book searchBookById(String bookID) {
        return books.stream()
                .filter(book -> book.getBookID().equals(bookID))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found: " + bookID));
    }

    @Override
    public List<Book> getAvailableBooksList() {
        return books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBorrowedBooksList() {
        return books.stream().filter(book-> !book.isAvailable()).collect(Collectors.toList());
    }
}
