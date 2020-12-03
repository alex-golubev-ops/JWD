package com.golubev.topicfirst.model;

import com.golubev.topicfirst.exception.FigureNotExistException;
import com.golubev.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

class MultiAngleFigure extends Figure implements FigurePropertiesStrategy {
    private final Logger LOGGER = LogManager.getLogger(MultiAngleFigure.class);

    public MultiAngleFigure(Point[] points) {
        this.points = points;
    }

    @Override
    public double perimeter() {
        int result = 0;
        for (int i = 0, j = i + 1; i < points.length; j++, i++) {
            result += Line.modul(points[i], points[j]);
        }
        return result;
    }

    @Override
    public String toString() {
        return "MultiAngleFigure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    public double square() throws FigureNotExistException {
        return points.length / 2 * Line.modul(points[0], points[1]) / (4 * Math.tan(360 / (points.length)));
    }
}
