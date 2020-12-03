package com.golubev.topicfirst.model;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Triangle extends Figure {
    private final Logger LOGGER = LogManager.getLogger(Triangle.class);

    public Triangle(Point[] points) {
        this.points = new Point[3];
        System.arraycopy(points, 0, this.points, 0, points.length);
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        System.arraycopy(points, 0, this.points, 0, points.length);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    public boolean check() {
        if (checkPoints()) {
            LOGGER.log(Level.ERROR, this.toString() + "is not exist");
            return false;
        }
        double[] lines = checkLines();
        if (lines[0] + lines[1] > lines[2] && lines[0] + lines[2] > lines[1] && lines[1] + lines[2] > lines[0]) {
            return true;
        }
        LOGGER.log(Level.ERROR, this.toString() + "is not triangle ");
        return false;
    }


}
