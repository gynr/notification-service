package com.gynr;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.gynr.enums.InputCommand;
import com.gynr.service.CommandService;
import com.gynr.service.impl.AddTopicCommandServiceImpl;
import com.gynr.service.impl.AddUserCommandServiceImpl;
import com.gynr.service.impl.ProcessMessageCommandServiceImpl;
import com.gynr.service.impl.PublishMessageCommandServiceImpl;
import com.gynr.service.impl.SubscribeTopicCommandServiceImpl;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        // List<String> valideCommands = InputCommand.getStringValues();
        Scanner in = new Scanner(System.in);

        String command = in.nextLine();
        while (command != null && command.isEmpty()) {

            String[] commandArr = command.split(" ");

            InputCommand commandType = InputCommand.valueOf(commandArr[0]);

            CommandService commandService;
            switch (commandType) {
                case addUser:
                    commandService = new AddUserCommandServiceImpl();
                    commandService.validateCommand(commandArr);
                    commandService.executeCommand(commandArr);

                    break;
                case addTopic:
                    commandService = new AddTopicCommandServiceImpl();
                    commandService.validateCommand(commandArr);
                    commandService.executeCommand(commandArr);

                    break;
                case subscribeTopic:
                    commandService = new SubscribeTopicCommandServiceImpl();
                    commandService.validateCommand(commandArr);
                    commandService.executeCommand(commandArr);

                    break;
                case publishMessage:
                    commandService = new PublishMessageCommandServiceImpl();
                    commandService.validateCommand(commandArr);
                    commandService.executeCommand(commandArr);

                    break;
                case processMessages:
                    commandService = new ProcessMessageCommandServiceImpl();
                    commandService.validateCommand(commandArr);
                    commandService.executeCommand(commandArr);

                    break;

                default:
                    System.out.println("command not found!");
                    break;

            }

            command = in.nextLine();

        }
        in.close();

    }
}
