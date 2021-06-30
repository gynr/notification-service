package com.gynr.enums;

import java.util.ArrayList;
import java.util.List;

public enum InputCommand {

    addUser, addTopic, subscribeTopic, publishMessage, processMessages;

    public static List<String> getStringValues() {
        List<String> resp = new ArrayList<>();
        InputCommand[] values = InputCommand.values();
        for (InputCommand value : values) {
            resp.add(value.toString());
        }
        return resp;
    }

}
