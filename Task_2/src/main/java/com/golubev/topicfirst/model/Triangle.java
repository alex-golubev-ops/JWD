package com.golubev.topicfirst.model;

import com.golubev.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

class Triangle extends Figure implements FigurePropertiesStrategy {
    private final Logger LOGGER = LogManager.getLogger(Triangle.class);

    public Triangle(Point[] points) {
        this.points = new Point[3];
        System.arraycopy(points, 0, this.points, 0, points.length);
    }


    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    public boolean check() {
        if (!checkPoints()) {
            LOGGER.log(Level.ERROR, this.toString() + "is not exist");
            return false;
        }
        double[] lines = checkLines();
        if (lines[3] + lines[4] > lines[5] && lines[5] + lines[4] > lines[3] && lines[3] + lines[5] > lines[4]) {
            return true;
        }
        LOGGER.log(Level.ERROR, this.toString() + "is not triangle ");
        return false;
    }

    public double square() {
        if (check()) {
            double semiPerimetr = semiPerimeter();
            LOGGER.log(Level.DEBUG, this.toString() + "square was counted");
            return Math.sqrt(semiPerimetr *
                    (semiPerimetr - Line.modul(points[0], points[1])) *
                    (semiPerimetr - Line.modul(points[1], points[2])) *
                    (semiPerimetr - Line.modul(points[2], points[0])));
        }
        LOGGER.log(Level.ERROR, this.toString() + "square was not counted");
        return 0;
    }


    private double semiPerimeter() {

        return perimeter() / 2;
    }

    public double perimeter() {
        if (check()) {
            LOGGER.log(Level.DEBUG, this.toString() + "perimeter was counted");
            return Line.modul(points[0], points[1]) +
                    Line.modul(points[1], points[2]) +
                    Line.modul(points[2], points[0]);
        }
        LOGGER.log(Level.ERROR, this.toString() + "perimeter was not counted");
        return 0;
    }
}
