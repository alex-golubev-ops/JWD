package com.golubev.topicfirst.model;

import com.golubev.topicfirst.exception.FigureNotExistException;
import com.golubev.topicfirst.strategy.FigurePropertiesStrategy;
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

    private FigurePropertiesStrategy strategy;

    public FigurePropertiesStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(FigurePropertiesStrategy strategy) {
        this.strategy = strategy;
    }

    public abstract boolean check();

    protected boolean checkPoints() {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public double getSquare() throws FigureNotExistException {
        return strategy.square();
    }

    public double getPerimeter() throws FigureNotExistException {
        return strategy.perimeter();
    }
    protected double[] getLines(int counter){
        double[] array = new double[counter];
        int numberPointsFirst=0;
        int numberPointsSecond=0;
        for (int i = 0; i < array.length; i++) {
            numberPointsSecond++;
            if(numberPointsSecond>=array.length){
                numberPointsSecond=0;
            }
            array[i]=Line.modul(points[numberPointsFirst],points[numberPointsSecond]);
            numberPointsFirst++;
        }
        return array;
    }

}
