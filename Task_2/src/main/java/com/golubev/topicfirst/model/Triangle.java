package com.golubev.topicfirst.model;

import com.golubev.topicfirst.strategy.FigurePropertiesStrategy;
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

    public double square() {
        double semiPerimetr = semiPerimeter();
        return Math.sqrt(semiPerimetr *
                (semiPerimetr - Line.modul(points[0], points[1])) *
                (semiPerimetr - Line.modul(points[1], points[2])) *
                (semiPerimetr - Line.modul(points[2], points[0])));
    }


    private double semiPerimeter() {
        return perimeter() / 2;
    }

    public double perimeter() {
        return Line.modul(points[0], points[1]) +
                Line.modul(points[1], points[2]) +
                Line.modul(points[2], points[0]);
    }
}
