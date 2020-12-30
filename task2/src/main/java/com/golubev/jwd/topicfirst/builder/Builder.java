package com.golubev.jwd.topicfirst.builder;

public interface Builder {
    void setSquare(double square);
    void setPerimeter(double perimeter);
    Criterion create();
}
