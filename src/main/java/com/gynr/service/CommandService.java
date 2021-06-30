package com.gynr.service;

public interface CommandService {

    public boolean validateCommand(String[] commandArr);

    public boolean executeCommand(String[] commandArr);

}
