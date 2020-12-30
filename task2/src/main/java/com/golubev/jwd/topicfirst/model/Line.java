package com.golubev.jwd.topicfirst.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {
    private List<Point> points;

    public Line(Point... points) {
        if (points.length == 2) {
            this.points = new ArrayList(Arrays.asList(points));

        }
    }

    public static double modul(Point first, Point second) {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2));
    }


    @Override
    public String toString() {
        return "Line{" +
                "points=" + points.toString() +
                '}';
    }

    public static List<Double> getLines(List<Point> points) {
        List<Double> array = new ArrayList<>(points.size());
        int numberPointsFirst = 0;
        int numberPointsSecond = 0;
        for (int i = 0; i < points.size(); i++) {
            numberPointsSecond++;
            if (numberPointsSecond >= points.size()) {
                numberPointsSecond = 0;
            }
            array.add(Line.modul(points.get(numberPointsFirst), points.get(numberPointsSecond)));
            numberPointsFirst++;
        }
        return array;
    }

}
