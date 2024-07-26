package lms.entity;

import lms.service.BookService;
import lms.service.BookServiceImpl;
import lms.service.TransactionService;

import java.util.List;

public class Member implements User {
    private String userID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private AccountStatus accountStatus;
    private String membershipID;
    private String membershipType;



    public Member(String userID, String name, String email, String phone, String address, String membershipID, String membershipType) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.accountStatus = AccountStatus.ACTIVE;
        this.membershipID = membershipID;
        this.membershipType = membershipType;

    }



    public String getUserID() {
        return userID;
    }
    public String getName(){
        return name;
    }

    @Override
    public void borrowBook(Book book) {
        if (accountStatus == AccountStatus.ACTIVE && book.isAvailable()) {
            book.borrow();
        } else {
            if(accountStatus==AccountStatus.INACTIVE)
            throw new IllegalStateException("Cannot borrow book since the user account is inactive.");
            else
                throw new IllegalArgumentException("Cannot borrow book. Book not available");
        }
    }

    @Override
    public void returnBook(Book book) {
        book.returnBook();
    }

    @Override
    public void reserveBook(Book book) {
        if (accountStatus == AccountStatus.ACTIVE && book.isAvailable()) {
            book.reserve();
        } else {
            throw new IllegalStateException("Cannot reserve book. Either the book is not available or the user account is inactive.");
        }
    }



    @Override
    public String toString() {
        return "Member{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", accountStatus=" + accountStatus +
                ", membershipID='" + membershipID + '\'' +
                ", membershipType='" + membershipType + '\'' +
                '}';
    }
}

enum AccountStatus {
    ACTIVE,
    INACTIVE
}
