package com.golubev.jwd.topicfirst.model;

import com.golubev.jwd.topicfirst.exception.FigureNotExistException;
import com.golubev.jwd.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public abstract class Figure {
    protected List<Point> points;


    private final Logger LOGGER = LogManager.getLogger(Figure.class);

    protected FigurePropertiesStrategy strategy;

    public List<Point> getPoints() {
        return points;
    }
    public void setPoints(List<Point> points){
        this.points = points;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + points +
                '}';
    }

    public double getSquare() throws FigureNotExistException {
        return strategy.square();
    }

    public double getPerimeter() throws FigureNotExistException {
        return strategy.perimeter();
    }


}
