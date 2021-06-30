package com.gynr.doa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gynr.model.Message;
import com.gynr.model.Topic;
import com.gynr.model.User;

public class TopicData {

    private static TopicData instance;
    private Map<String, List<User>> topicUsers = new HashMap<>();
    private Map<String, List<Message>> topicMessages = new HashMap<>();

    private TopicData() {

    }

    public static TopicData getInstance() {

        if (instance == null) {
            synchronized (TopicData.class) {
                if (instance == null) {
                    return new TopicData();
                }
            }
        }

        return instance;
    }

    public Map<String, List<User>> getTopicUsers() {
        return topicUsers;
    }

    public Map<String, List<Message>> getTopicMessages() {
        return topicMessages;
    }

}
