package lms.service;

import lms.entity.Member;
import lms.entity.User;

import java.util.List;

public interface UserService {
    void addUser(Member user);

    void updateUser(Member user);

    void deleteUser(Member user);

    User getUser(String userID);
    List<Member> getAllUsers();
}
