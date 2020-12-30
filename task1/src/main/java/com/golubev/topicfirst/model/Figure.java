package com.golubev.topicfirst.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public abstract class Figure {
    protected Point[] points;
    private final Logger LOGGER = LogManager.getLogger(Figure.class);

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

    protected double[] checkLines() {
        double[] array = new double[6];
        int k = 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                array[k] = Line.modul(points[i], points[j]);
            }
        }
        Arrays.sort(array);
        return array;
    }
}
