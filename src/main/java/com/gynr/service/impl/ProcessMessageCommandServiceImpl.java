package com.gynr.service.impl;

import java.util.List;

import com.google.gson.Gson;
import com.gynr.model.Message;
import com.gynr.model.NotificationPayload;
import com.gynr.model.Topic;
import com.gynr.model.User;
import com.gynr.repository.TopicRepository;
import com.gynr.service.CommandService;

public class ProcessMessageCommandServiceImpl implements CommandService {

    @Override
    public boolean validateCommand(String[] commandArr) {
        if (commandArr.length != 1)
            return false;

        return true;
    }

    @Override
    public boolean executeCommand(String[] commandArr) {
        String messageString = commandArr[1];

        Gson gson = new Gson();

        Message message = gson.fromJson(messageString, Message.class);

        TopicRepository topicRepository = new TopicRepository();

        List<Message> messages = topicRepository.getAllMessages();

        for (Message msg : messages) {

            String topicName = msg.getTopicName();
            List<User> usersByTopic = topicRepository.getUsersByTopic(topicName);

            for (User user : usersByTopic) {
                NotificationPayload notificationPayload = new NotificationPayload();
                notificationPayload.setMessage(msg.getText());
                notificationPayload.setSendTo(user.getName());
                notificationPayload.setTopic(msg.getText());

                System.out.println(gson.toJson(notificationPayload, NotificationPayload.class));
            }

        }

        return true;
    }

}
