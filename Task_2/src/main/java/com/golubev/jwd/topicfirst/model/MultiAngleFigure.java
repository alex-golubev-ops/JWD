package com.golubev.jwd.topicfirst.model;

import com.golubev.jwd.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

class MultiAngleFigure extends Figure implements FigurePropertiesStrategy {
    private final Logger LOGGER = LogManager.getLogger(MultiAngleFigure.class);

    public MultiAngleFigure(List<Point> points) {
        this.points = new ArrayList<>(points);
        strategy = this;
    }

    @Override
    public double perimeter() {
        List<Double> lines = Line.getLines(points);
        int perimeter = 0;
        for (double line : lines) {
            perimeter += line;
        }
        return perimeter;
    }

    @Override
    public String toString() {
        return "MultiAngleFigure{" +
                "points=" + points.toString() +
                '}';
    }

    @Override
    public double square() {
        return points.size() / 2 * Line.modul(points.get(0), points.get(1)) / (4 * Math.tan(360 / (points.size())));
    }


}
