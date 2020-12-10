package com.golubev.jwd.topicfirst.model;

import com.golubev.jwd.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Triangle extends Figure implements FigurePropertiesStrategy {
    private final Logger LOGGER = LogManager.getLogger(Triangle.class);

    public Triangle(List<Point> points) {
        this.points = new ArrayList<>(points);
        strategy = this;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + points.toString() +
                '}';
    }

    public double square() {
        double semiPerimetr = semiPerimeter();
        List<Double> lines = Line.getLines(points);
        return Math.sqrt(semiPerimetr *
                (semiPerimetr - lines.get(0)) *
                (semiPerimetr - lines.get(1)) *
                (semiPerimetr - lines.get(2)));
    }


    private double semiPerimeter() {
        return perimeter() / 2;
    }

    public double perimeter() {
       List<Double> lines = Line.getLines(points);
       double perimeter = 0;
        for (Double line : lines) {
            perimeter += line;
        }
        return perimeter;
    }



}
