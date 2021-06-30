package com.gynr.service.impl;

import com.google.gson.Gson;
import com.gynr.model.Message;
import com.gynr.model.Topic;
import com.gynr.repository.TopicRepository;
import com.gynr.service.CommandService;

public class PublishMessageCommandServiceImpl implements CommandService {

    @Override
    public boolean validateCommand(String[] commandArr) {
        if (commandArr.length != 2 || commandArr[1].isEmpty())
            return false;

        return true;
    }

    @Override
    public boolean executeCommand(String[] commandArr) {
        String messageString = commandArr[1];

        Gson gson = new Gson();

        Message message = gson.fromJson(messageString, Message.class);

        TopicRepository topicRepository = new TopicRepository();

        Topic topic = new Topic();
        topic.setName(message.getTopicName());
        topicRepository.addMessageToTopic(topic, message);

        return true;
    }

}
