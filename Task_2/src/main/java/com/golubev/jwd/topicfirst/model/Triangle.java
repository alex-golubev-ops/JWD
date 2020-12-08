package com.golubev.jwd.topicfirst.model;

import com.golubev.jwd.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

class Triangle extends Figure implements FigurePropertiesStrategy {
    private final Logger LOGGER = LogManager.getLogger(Triangle.class);

    public Triangle(Point[] points) {
        this.points = new Point[3];
        System.arraycopy(points, 0, this.points, 0, points.length);
        strategy = this;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    public double square() {
        double semiPerimetr = semiPerimeter();
        double[] lines = Line.getLines(points);
        return Math.sqrt(semiPerimetr *
                (semiPerimetr - lines[0]) *
                (semiPerimetr - lines[1]) *
                (semiPerimetr - lines[2]));
    }


    private double semiPerimeter() {
        return perimeter() / 2;
    }

    public double perimeter() {
       double[] lines = Line.getLines(points);
       double perimeter = 0;
        for (int i = 0; i < lines.length; i++) {
            perimeter+=lines[i];
        }
        return perimeter;
    }



}
