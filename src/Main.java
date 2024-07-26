

import lms.entity.*;
        import lms.service.*;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        BookService bookService = new BookServiceImpl();
        UserService userService = new UserServiceImpl();
        TransactionService transactionService = new TransactionServiceImpl(bookService, userService);


        // Creating  book objects
        Book book1 = new Book("1", "Effective Java", "Joshua Bloch", "Addison-Wesley", "978-0134685991",
                new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-06"), "Programming");
        Book book2=new Book("2", "C programming", "Kelvin R.", "Kelvin R.", "768-0138085900",
                new SimpleDateFormat("yyyy-MM-dd").parse("1990-04-08"), "Programming");
        Book book3=new Book("3", "Harry Potter", "JKR", "JKR", "228-0567085117",
                new SimpleDateFormat("yyyy-MM-dd").parse("2000-07-11"), "Fiction");
        Book book4=new Book("4", "A tale of two cities", "Harper Lee", "JKR", "555-1247085198",
                new SimpleDateFormat("yyyy-MM-dd").parse("2012-12-12"), "Fiction");
        Book book5=new Book("5", "Dark Matter", "Blake Crouch", "Blake Crouch", "555-1247085198",
                new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-11"), "Fiction");
        Book book6=new Book("6", "The Silent Patient", "Alex M", "Alex M", "555-4577885438",
                new SimpleDateFormat("yyyy-MM-dd").parse("1880-10-10"), "Fiction");


        //adding books to the inventory
        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
        bookService.addBook(book4);
        bookService.addBook(book5);
        bookService.addBook(book6);

        //update book
        Book book7=new Book("3", "Harry Potter", "JKR", "JKR", "228-0567085117",
                new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-11"), "Programming");
        bookService.updateBook(book7);

        //delete book
        bookService.deleteBook(book6);



        // Creating users
        Member user1 = new Member("1", "John Doe", "john.doe@gmail.com", "1234567890", "123 Main St", "M1", "Regular");
        Member user2 = new Member("2", "Bob R", "bob.@gmail.com", "2345678912", "333 St. Laurent street", "M2", "Regular");
        Member user3=new Member("3", "Robin R", "robin.@gmail.com", "2345678912", "20th street 47W,NY", "M3", "Regular");
        Member user4=new Member("4", "Jay Raman", "jr.@gmail.com", "7709127843", "10th street, CL", "M4", "Regular");

        //Adding users
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);

        //updating user
        Member user5=new Member("4", "Jay Raman", "jr.@gmail.com", "2145698735", "10th street, CL", "M4", "Regular");
        userService.updateUser(user5);

        //delete user
        userService.deleteUser(user4);



        //book checkout and return functionality
        transactionService.borrowBook("2","3");
        transactionService.borrowBook("2","1");
        transactionService.returnBook("2","1");
        transactionService.borrowBook("3","4");


        //borrowing history of a member
        System.out.println(transactionService.getUserTransactions("2"));

        //Inventory management
        System.out.println("List of available books: "+bookService.getAvailableBooksList());
        System.out.println("List of borrowed books: "+bookService.getBorrowedBooksList());


    }
}