package com.golubev.jwd.topicfirst.factory;

import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.model.Figure;
import com.golubev.jwd.topicfirst.model.FigureType;
import com.golubev.jwd.topicfirst.model.Point;

import java.util.List;

public interface FigureFactory {
    Figure createFigure(FigureType type, List<Point> figureConstituents) throws FigureException;
}
