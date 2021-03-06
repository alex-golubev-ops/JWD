package com.golubev.jwd.topicfirst.model;

import com.golubev.jwd.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

class Square extends Figure implements FigurePropertiesStrategy {
    private final Logger LOGGER = LogManager.getLogger(Square.class);

    public Square(List<Point> points) {
        this.points = new ArrayList<>(points);
        strategy = this;
    }

    @Override
    public String toString() {
        return "Square{" +
                "points=" + points.toString() +
                '}';
    }

    public double square() {
        return Math.pow(Line.modul(points.get(0), points.get(1)), 2);
    }

    public double perimeter() {
        return 4 * Line.modul(points.get(0), points.get(1));
    }


}
