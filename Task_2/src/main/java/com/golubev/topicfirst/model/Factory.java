package com.golubev.topicfirst.model;

import com.golubev.topicfirst.exception.FigureException;

public interface Factory {
    Square getSquare(Point[] points) throws FigureException;
    Triangle getTriangle(Point[] points) throws FigureException;
    MultiAngleFigure getMultiAngleFigure(Point[] points) throws FigureException;
}
