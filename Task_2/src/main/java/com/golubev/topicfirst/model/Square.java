package com.golubev.topicfirst.model;

import com.golubev.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

class Square extends Figure implements FigurePropertiesStrategy {
    private final Logger LOGGER = LogManager.getLogger(Square.class);

    public Square(Point[] points) {
        this.points = new Point[4];
        System.arraycopy(points, 0, this.points, 0, points.length);
    }

    @Override
    public String toString() {
        return "Square{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    public double square() {
        return Math.pow(Line.modul(points[0], points[1]), 2);
    }

    public double perimeter() {
        return 4 * Line.modul(points[0], points[1]);
    }

    @Override
    public boolean check() {
        if (!checkPoints()) {
            return false;
        }
        double[] lines = getLines(points.length);
        double line = lines[0];
        for (int i = 0; i < lines.length; i++) {
            if (line != lines[i]) {
                return false;
            }
        }
        return true;
    }
}
