package com.golubev.topicfirst;


import com.golubev.topicfirst.app.TaskSecond;

public class Main {
    public static void main(String[] args) {
        TaskSecond taskSecond = TaskSecond.getInstance();
        taskSecond.run();

    }
}
