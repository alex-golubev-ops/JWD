package com.golubev.topicfirst.model;

public interface Factory {
    Square getSquare(Point[] points);
    Triangle getTriangle(Point[] points);
    MultiAngleFigure getMultiAngleFigure(Point[] points);
}
