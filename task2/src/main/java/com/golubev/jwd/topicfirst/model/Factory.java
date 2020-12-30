package com.golubev.jwd.topicfirst.model;

import com.golubev.jwd.topicfirst.exception.FigureException;

import java.util.List;

public interface Factory {
    Figure createFigure(FigureType type, List<Point> points) throws FigureException;
}
