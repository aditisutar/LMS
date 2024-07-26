package lms.entity;

import java.util.Date;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private String publisher;
    private String ISBN;
    private Date publicationDate;
    private BookStatus status;
    private String genre;

    public Book(String bookID, String title, String author, String publisher, String ISBN, Date publicationDate, String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.publicationDate = publicationDate;
        this.status = BookStatus.AVAILABLE;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publicationDate=" + publicationDate +
                ", status=" + status +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public BookStatus getStatus() {
        return status;
    }

    public String getGenre() {
        return genre;
    }

    public void borrow() {
        if (isAvailable()) {
            this.status = BookStatus.BORROWED;
        } else {
            throw new IllegalStateException("Book is not available for borrowing.");
        }
    }

    public void returnBook() {
        this.status = BookStatus.AVAILABLE;
    }

    public void reserve() {
        if (isAvailable()) {
            this.status = BookStatus.RESERVED;
        } else {
            throw new IllegalStateException("Book is not available for reservation.");
        }
    }

    public boolean isAvailable() {
        return this.status == BookStatus.AVAILABLE;
    }

}
enum BookStatus {
    AVAILABLE,
    RESERVED,
    BORROWED
}
