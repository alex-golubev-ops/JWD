package com.golubev.topicfirst;


import com.golubev.topicfirst.app.TaskSecond;
import com.golubev.topicfirst.exception.FigureException;


public class Main {
    public static void main(String[] args) throws FigureException {
        TaskSecond taskSecond = TaskSecond.getInstance();
        taskSecond.run();

    }
}
