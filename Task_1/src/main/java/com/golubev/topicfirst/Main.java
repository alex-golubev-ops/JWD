package com.golubev.topicfirst;


import com.golubev.topicfirst.app.TaskFirst;

public class Main {
    public static void main(String[] args) {
        TaskFirst taskFirst =TaskFirst.getInstance();
        taskFirst.run();
    }
}
