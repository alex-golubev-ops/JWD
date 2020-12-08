package com.golubev.jwd.topicfirst.model;

import java.util.Arrays;

public class Line {
    private final Point[] points = new Point[2];

    public Line(Point[] points) {
        System.arraycopy(points, 0, this.points, 0, points.length);
    }

    public static double modul(Point first, Point second) {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2));
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        System.arraycopy(points, 0, this.points, 0, points.length);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
    public static  double[] getLines(Point[] points){
        double[] array = new double[points.length];
        int numberPointsFirst=0;
        int numberPointsSecond=0;
        for (int i = 0; i < array.length; i++) {
            numberPointsSecond++;
            if(numberPointsSecond>=array.length){
                numberPointsSecond=0;
            }
            array[i]=Line.modul(points[numberPointsFirst],points[numberPointsSecond]);
            numberPointsFirst++;
        }
        return array;
    }

}
