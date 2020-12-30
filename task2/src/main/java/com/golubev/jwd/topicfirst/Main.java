package com.golubev.jwd.topicfirst;


import com.golubev.jwd.topicfirst.app.TaskThird;
import com.golubev.jwd.topicfirst.exception.FigureException;


public class Main {
    public static void main(String[] args) throws FigureException {
        TaskThird taskThird = TaskThird.getInstance();
        taskThird.run();

    }
}
