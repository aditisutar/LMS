package lms.service;

import lms.entity.Member;
import lms.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

    private Map<String, Member> users = new HashMap<>();

    @Override
    public void addUser(Member user) {
        if (users.containsKey(user.getUserID())) {
            throw new IllegalArgumentException("User already exists with user userID as: " + user.getUserID());
        }
        users.put(user.getUserID(), user);
        LOGGER.info("User added: " + user.getName());
    }

    @Override
    public void updateUser(Member user) {
        if (!users.containsKey(user.getUserID())) {
            throw new IllegalArgumentException("User not found: " + user.getUserID());
        }
        users.put(user.getUserID(), user);
        LOGGER.info("User updated: " + user.getName());
    }

    @Override
    public void deleteUser(Member user) {
        if (!users.containsKey(user.getUserID())) {
            throw new IllegalArgumentException("User not found: " + user.getUserID());
        }
        users.remove(user.getUserID());
        LOGGER.info("User deleted: " + user.getUserID());
    }

    @Override
    public User getUser(String userID) {
        if (!users.containsKey(userID)) {
            throw new IllegalArgumentException("User not found: " + userID);
        }
        return users.get(userID);
    }

    @Override
    public List<Member> getAllUsers() {
        List<Member> members=new ArrayList<>();
        for(Map.Entry<String,Member>m:users.entrySet()){
            Member member= m.getValue();
            members.add(member);
        }
        return members;
    }
}

