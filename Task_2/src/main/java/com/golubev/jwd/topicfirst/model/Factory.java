package com.golubev.jwd.topicfirst.model;

import com.golubev.jwd.topicfirst.exception.FigureException;

public interface Factory {
    Figure createFigure(FigureType type, Point[] points) throws FigureException;
}
