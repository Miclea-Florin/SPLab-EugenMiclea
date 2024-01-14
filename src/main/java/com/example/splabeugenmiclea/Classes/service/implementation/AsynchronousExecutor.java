package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.service.Command;
import com.example.splabeugenmiclea.Classes.service.CommandExecutor;

public class AsynchronousExecutor implements CommandExecutor {

    public Request executeCommand(Command command, BookService bookService){
        return new Request<>(0,command,false,null);

    }

}
