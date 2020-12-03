package com.golubev.topicfirst.model;

import com.golubev.topicfirst.strategy.FigurePropertiesStrategy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

class Square extends Figure implements FigurePropertiesStrategy {
    private final Logger LOGGER = LogManager.getLogger(Square.class);

    public Square(Point[] points) {
        this.points = new Point[4];
        System.arraycopy(points, 0, this.points, 0, points.length);
    }


    public boolean check() {
        if (checkPoints()) {
            LOGGER.log(Level.ERROR, this.toString() + " is not exist");
            return false;
        }
        double[] lines = checkLines();
        if (lines[0] == lines[3] && lines[4] == lines[5]) {
            return true;
        }
        LOGGER.log(Level.ERROR, this.toString() + "is not square ");
        return false;
    }

    @Override
    public String toString() {
        return "Square{" +
                "points=" + Arrays.toString(points) +
                '}';
    }


    public double square() {
        if (check()) {

            LOGGER.log(Level.DEBUG, this.toString() + "square was counted");
            return Math.pow(Line.modul(points[0], points[1]), 2);
        }
        LOGGER.log(Level.ERROR, this.toString() + "square was not counted");
        return 0;
    }


    public double perimeter() {
        if (!check()) {
            LOGGER.log(Level.DEBUG, this.toString() + "perimeter was counted");
            return 4 * Line.modul(points[0], points[1]);
        }
        LOGGER.log(Level.ERROR, this.toString() + "perimeter was not counted");
        return 0;
    }
}
