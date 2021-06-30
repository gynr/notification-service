package com.gynr.repository;

import java.util.Map;

import com.gynr.doa.UserData;
import com.gynr.model.User;

public class UserRepository {

    public User addUser(User user) {
        Map<String, User> users = UserData.getInstance().getUsers();
        return users.put(user.getName(), user);
    }

    public User removeUser(User user) {
        Map<String, User> users = UserData.getInstance().getUsers();
        return users.remove(user.getName());
    }

    public User getUser(String userName) {
        Map<String, User> users = UserData.getInstance().getUsers();
        return users.get(userName);
    }

}
