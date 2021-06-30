package com.gynr.service.impl;

import com.gynr.doa.UserData;
import com.gynr.enums.RoleType;
import com.gynr.model.Topic;
import com.gynr.model.User;
import com.gynr.repository.TopicRepository;
import com.gynr.repository.UserRepository;
import com.gynr.service.CommandService;

public class AddTopicCommandServiceImpl implements CommandService {

    @Override
    public boolean validateCommand(String[] commandArr) {
        if (commandArr.length != 3 || commandArr[1].isEmpty() || commandArr[2].isEmpty())
            return false;
        String userName = commandArr[2];
        UserRepository userRepository = new UserRepository();

        User user = userRepository.getUser(userName);

        if (!user.getRole().equals(RoleType.ADMIN)) {
            System.out.println("Only admin can add topics.");
            return false;
        }

        return true;
    }

    @Override
    public boolean executeCommand(String[] commandArr) {
        String topicName = commandArr[1];
        TopicRepository topicRepository = new TopicRepository();
        Topic topic = new Topic();
        topic.setName(topicName);
        topicRepository.addTopic(topic);
        return true;
    }

}
