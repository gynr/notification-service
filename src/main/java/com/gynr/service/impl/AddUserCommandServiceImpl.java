package com.gynr.service.impl;

import com.gynr.doa.UserData;
import com.gynr.enums.RoleType;
import com.gynr.exception.NotificationServiceException;
import com.gynr.model.User;
import com.gynr.repository.UserRepository;
import com.gynr.service.CommandService;

public class AddUserCommandServiceImpl implements CommandService {

    @Override
    public boolean validateCommand(String[] commandArr) {
        if (commandArr.length != 3 || commandArr[1].isEmpty() || commandArr[2].isEmpty())
            return false;

        return true;
    }

    @Override
    public boolean executeCommand(String[] commandArr) {
        User user = new User();
        user.setName(commandArr[1]);
        RoleType role = RoleType.valueOf(commandArr[2]);
        user.setRole(role);

        UserRepository userRepository = new UserRepository();

        try {
            userRepository.addUser(user);
        } catch (Exception e) {

            throw new NotificationServiceException("Cannot add user!");
        }
        return true;
    }

}
