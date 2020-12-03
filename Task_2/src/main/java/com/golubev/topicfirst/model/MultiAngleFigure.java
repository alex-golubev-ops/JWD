package com.golubev.topicfirst.model;

import com.golubev.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

class MultiAngleFigure extends Figure implements FigurePropertiesStrategy {
    private final Logger LOGGER = LogManager.getLogger(MultiAngleFigure.class);

    public MultiAngleFigure(Point[] points) {
        this.points = points;
    }

    @Override
    public boolean check() {
        if (checkPoints()) {
            LOGGER.log(Level.ERROR, this.toString() + " is not exist");
            return false;
        }
        return true;
    }

    @Override
    public double perimeter() {
        if (check()) {
            int result = 0;
            for (int i = 0, j = i + 1; i < points.length; j++, i++) {
                result += Line.modul(points[i], points[j]);
            }
            LOGGER.log(Level.DEBUG, this.toString() + "perimeter was counted");
            return result;
        }
        LOGGER.log(Level.ERROR, this.toString() + "perimeter was not counted");
        return 0;

    }

    @Override
    public String toString() {
        return "MultiAngleFigure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    public double square() {
        if (check()) {
            return points.length / 2 * Line.modul(points[0], points[1]) / (4 * Math.tan(360 / (points.length)));
        }
        LOGGER.log(Level.ERROR, this.toString() + "square was not counted");
        return 0;
    }
}
