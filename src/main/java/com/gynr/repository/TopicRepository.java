package com.gynr.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.gynr.doa.TopicData;
import com.gynr.model.Message;
import com.gynr.model.Topic;
import com.gynr.model.User;

public class TopicRepository {

    public Topic addTopic(Topic topic) {
        Map<String, List<User>> topicUsers = TopicData.getInstance().getTopicUsers();
        Map<String, List<Message>> topicMsgs = TopicData.getInstance().getTopicMessages();

        /* Initialize topic users store */
        if (!topicUsers.containsKey(topic.getName())) {
            List<User> users = new ArrayList<>();
            topicUsers.put(topic.getName(), users);
        }

        /* Initialize topic messages store */
        if (!topicMsgs.containsKey(topic.getName())) {
            List<Message> users = new ArrayList<>();
            topicMsgs.put(topic.getName(), users);
        }
        return topic;
    }

    public void removeTopic(Topic topic) {
        Map<String, List<User>> topicUsers = TopicData.getInstance().getTopicUsers();
        Map<String, List<Message>> topicMsgs = TopicData.getInstance().getTopicMessages();

        topicUsers.remove(topic.getName());
        topicMsgs.remove(topic.getName());

    }

    public boolean addUserToTopic(Topic topic, User user) {
        Map<String, List<User>> topicUsers = TopicData.getInstance().getTopicUsers();

        return topicUsers.get(topic.getName()).add(user);

    }

    public boolean addMessageToTopic(Topic topic, Message message) {
        Map<String, List<Message>> topicMsgs = TopicData.getInstance().getTopicMessages();

        return topicMsgs.get(topic.getName()).add(message);

    }

    public List<Message> getAllMessages() {
        Map<String, List<Message>> topicMsgs = TopicData.getInstance().getTopicMessages();

        return topicMsgs.values().stream().flatMap(List::stream).collect(Collectors.toList());

    }

    public List<Message> getMessagesByTopic(String topicName) {
        Map<String, List<Message>> topicMsgs = TopicData.getInstance().getTopicMessages();

        return topicMsgs.get(topicName);

    }

    public List<User> getUsersByTopic(String topicName) {
        Map<String, List<User>> topicMsgs = TopicData.getInstance().getTopicUsers();

        return topicMsgs.get(topicName);

    }
}
