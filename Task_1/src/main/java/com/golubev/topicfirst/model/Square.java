package com.golubev.topicfirst.model;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class Square extends Figure {
    private final Logger LOGGER = LogManager.getLogger(Square.class);

    public Square(Point[] points) {
        this.points = new Point[4];
        System.arraycopy(points, 0, this.points, 0, points.length);
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
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


}
