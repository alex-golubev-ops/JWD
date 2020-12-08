package com.golubev.jwd.topicfirst.model;

import com.golubev.jwd.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

class MultiAngleFigure extends Figure implements FigurePropertiesStrategy {
    private final Logger LOGGER = LogManager.getLogger(MultiAngleFigure.class);

    public MultiAngleFigure(Point[] points) {
        this.points = points;
        strategy= this;
    }

    @Override
    public double perimeter() {
        double[] lines = Line.getLines(points);
        int perimeter = 0;
        for (double line : lines) {
            perimeter += line;
        }
        return perimeter;
    }

    @Override
    public String toString() {
        return "MultiAngleFigure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    public double square() {
        return points.length / 2 * Line.modul(points[0], points[1]) / (4 * Math.tan(360 / (points.length)));
    }


}
