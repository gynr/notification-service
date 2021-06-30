package com.gynr.doa;

import java.util.HashMap;
import java.util.Map;

import com.gynr.model.User;

public class UserData {
    private static UserData instance;
    private static Map<String, User> users = new HashMap<>();

    private UserData() {

    }

    public static UserData getInstance() {

        if (instance == null) {
            synchronized (UserData.class) {
                if (instance == null) {
                    return new UserData();
                }
            }
        }

        return instance;
    }

    public Map<String, User> getUsers() {
        return users;
    }

}
