package com.golubev.jwd.topicfirst.model;

import com.golubev.jwd.topicfirst.exception.FigureNotExistException;
import com.golubev.jwd.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Figure {
    protected Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    private final Logger LOGGER = LogManager.getLogger(Figure.class);

    protected FigurePropertiesStrategy strategy;


    public double getSquare() throws FigureNotExistException {
        return strategy.square();
    }

    public double getPerimeter() throws FigureNotExistException {
        return strategy.perimeter();
    }


}
