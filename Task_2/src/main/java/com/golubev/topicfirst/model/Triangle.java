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

    public double square() {
        double semiPerimetr = semiPerimeter();
        double[] lines = getLines(points.length);
        return Math.sqrt(semiPerimetr *
                (semiPerimetr - lines[0]) *
                (semiPerimetr - lines[1]) *
                (semiPerimetr - lines[2]));
    }


    private double semiPerimeter() {
        return perimeter() / 2;
    }

    public double perimeter() {
       double[] lines = getLines(points.length);
       double perimeter = 0;
        for (int i = 0; i < lines.length; i++) {
            perimeter+=lines[i];
        }
        return perimeter;
    }

    @Override
    public boolean check() {
        if (!checkPoints()) {
            return false;
        }
        double[] lines = getLines(points.length);
        if (    lines[0] + lines[1] >= lines[2] &&
                lines[1] + lines[2] >= lines[0] &&
                lines[2] + lines[0] >= lines[1]
        ){
            return true;
        }
        return false;

    }

}
