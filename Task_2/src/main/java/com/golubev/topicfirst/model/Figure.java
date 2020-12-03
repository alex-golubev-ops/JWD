package com.golubev.topicfirst.model;

import com.golubev.topicfirst.exception.FigureNotExistException;
import com.golubev.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public abstract class Figure {
    protected Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    private final Logger LOGGER = LogManager.getLogger(Figure.class);

    private FigurePropertiesStrategy strategy;

    public FigurePropertiesStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(FigurePropertiesStrategy strategy) {
        this.strategy = strategy;
    }



    public double getSquare() throws FigureNotExistException {
        return strategy.square();
    }

    public double getPerimeter() throws FigureNotExistException {
        return strategy.perimeter();
    }
}
