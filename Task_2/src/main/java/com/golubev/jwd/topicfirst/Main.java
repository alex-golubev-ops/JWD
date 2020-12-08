package com.golubev.jwd.topicfirst;


import com.golubev.jwd.topicfirst.app.TaskSecond;
import com.golubev.jwd.topicfirst.exception.FigureException;


public class Main {
    public static void main(String[] args) throws FigureException {
        TaskSecond taskSecond = TaskSecond.getInstance();
        taskSecond.run();

    }
}
