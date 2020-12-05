package com.golubev.topicfirst.app;

import com.golubev.topicfirst.exception.FigureException;
import com.golubev.topicfirst.exception.FigureNotExistException;
import com.golubev.topicfirst.model.Factory;
import com.golubev.topicfirst.model.Figure;
import com.golubev.topicfirst.model.FigureFactory;
import com.golubev.topicfirst.model.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

public final class TaskSecond {
    private final Logger LOGGER = LogManager.getLogger(TaskSecond.class);
    private static TaskSecond instance;
    private Figure square;
    private Figure triangle;
    private Figure multiAngleFigure;
    private Factory factory = FigureFactory.getInstance();

    private TaskSecond() {
        try {
            square = factory.getSquare(new Point[]{new Point(2,1),
                    new Point(4,1), new Point(4,3), new Point(2,3)});
            square.setStrategy(factory.getSquare(new Point[]{new Point(2,1),
                    new Point(4,1), new Point(4,3), new Point(2,3)}));
            triangle = factory.getTriangle(new Point[]{new Point(1,1),
                    new Point(2,1), new Point(2,3)});
            triangle.setStrategy(factory.getTriangle(new Point[]{
                    new Point(1,1), new Point(2,1), new Point(2,3)}));
            multiAngleFigure = factory.getMultiAngleFigure(new Point[]{new Point(3,2),
            new Point(5,2),new Point(7,4), new Point(9,4), new Point(9,6),new Point(3,6)});
            multiAngleFigure.setStrategy(factory.getMultiAngleFigure(new Point[]{new Point(3,2),
                    new Point(5,2),new Point(7,4), new Point(9,4),
                    new Point(9,6),new Point(3,6)}));
        } catch (FigureException e) {
            e.printStackTrace();
        }
    }

    private Point[] generationPoints(int counterGenerationPoints) {
        Point[] generationPoints = new Point[counterGenerationPoints];
        Random random = new Random();
        for (int i = 0; i < generationPoints.length; i++) {
            generationPoints[i] = new Point(random.nextInt(10), random.nextInt(10));
        }
        return generationPoints;
    }

    public void run() {
        try {
            LOGGER.log(Level.DEBUG, "start application");
            LOGGER.log(Level.INFO, triangle.toString() + " perimeter: " + triangle.getPerimeter());
            LOGGER.log(Level.INFO, triangle.toString() + " square: " + triangle.getSquare());
            LOGGER.log(Level.INFO, square.toString() + " perimeter: " + square.getPerimeter());
            LOGGER.log(Level.INFO, square.toString() + " square: " + square.getSquare());
            LOGGER.log(Level.INFO, multiAngleFigure.toString() + " square: " + multiAngleFigure.getSquare());
            LOGGER.log(Level.INFO, multiAngleFigure.toString() + " perimeter: " + multiAngleFigure.getPerimeter());
            LOGGER.log(Level.DEBUG, "finish application");
        }catch (FigureNotExistException e) {
            e.printStackTrace();
        }
    }

    public static TaskSecond getInstance() {
        if (instance == null) {
            instance = new TaskSecond();
        }
        return instance;
    }

}
