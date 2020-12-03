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

    //        public double square() {
//            if (check()){
//                return Math.pow(module(firstTop,secondTop),2);
//            }
//            LOGGER.log(Level.WARN,this.toString()+" Square was not counted ");
//            return 0;
//
//        }
//
//        public double perimeter() {
//            if(check()){
//                LOGGER.log(Level.DEBUG, this.toString()+" Perimeter is counting");
//                return 4*module(firstTop,secondTop) ;
//            }
//            LOGGER.log(Level.ERROR,this.toString()+ this.toString()+" Perimeter was not counted ");
//            return 0;
//        }
}
