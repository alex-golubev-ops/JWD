package com.golubev.topicfirst.model;

import com.golubev.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public abstract class Figure {
    protected Point[] points;
    private final Logger LOGGER = LogManager.getLogger(Figure.class);

    private FigurePropertiesStrategy strategy;

    public abstract boolean check();

    public FigurePropertiesStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(FigurePropertiesStrategy strategy) {
        this.strategy = strategy;
    }

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

    protected double[] checkLines() {
        double[] array = new double[6];
        int k = 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                array[k] = Line.modul(points[i], points[j]);
                k++;
            }
        }
        Arrays.sort(array);
        return array;
    }

    public double getSquare() {
        return strategy.square();
    }

    public double getPerimeter() {
        return strategy.perimeter();
    }
}
