package com.gynr.service.impl;

import com.gynr.exception.NotificationServiceException;
import com.gynr.model.Topic;
import com.gynr.model.User;
import com.gynr.repository.TopicRepository;
import com.gynr.repository.UserRepository;
import com.gynr.service.CommandService;

public class SubscribeTopicCommandServiceImpl implements CommandService {

    @Override
    public boolean validateCommand(String[] commandArr) {
        if (commandArr.length != 3 || commandArr[1].isEmpty() || commandArr[2].isEmpty())
            return false;
        

        return true;
    }

    @Override
    public boolean executeCommand(String[] commandArr) {
        String userName = commandArr[2];
        String topicName = commandArr[1];

        TopicRepository topicRepository = new TopicRepository();

        Topic topic = new Topic();
        topic.setName(topicName);

        UserRepository userRepository = new UserRepository();

        User user = null;
        try {
            user = userRepository.getUser(userName);
        } catch (Exception e) {

            throw new NotificationServiceException("user not valid!");
        }

        topicRepository.addUserToTopic(topic, user);
        return true;
    }

}
