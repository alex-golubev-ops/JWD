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
      double[] lines = getLines(points.length);
      int perimeter = 0;
        for (double line : lines) {
            perimeter+=line;
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
    public double square()  {
        return points.length / 2 * Line.modul(points[0], points[1]) / (4 * Math.tan(360 / (points.length)));
    }

    @Override
    public boolean check() {
        if (!checkPoints()) {
            return false;
        }
        return true;
    }
}
