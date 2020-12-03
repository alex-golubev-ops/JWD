package com.golubev.topicfirst.app;

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
        square = factory.getSquare(generationPoints(4));
        square.setStrategy(factory.getSquare(generationPoints(4)));
        triangle = factory.getTriangle(generationPoints(3));
        triangle.setStrategy(factory.getTriangle(generationPoints(3)));
        multiAngleFigure = factory.getMultiAngleFigure(generationPoints(5));
        multiAngleFigure.setStrategy(factory.getMultiAngleFigure(generationPoints(5)));
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
        LOGGER.log(Level.DEBUG, "start application");
        LOGGER.log(Level.INFO, triangle.toString() + " perimeter: " + triangle.getPerimeter());
        LOGGER.log(Level.INFO, triangle.toString() + " square: " + triangle.getSquare());
        LOGGER.log(Level.INFO, square.toString() + " perimeter: " + triangle.getPerimeter());
        LOGGER.log(Level.INFO, square.toString() + " square: " + triangle.getSquare());
        LOGGER.log(Level.INFO, multiAngleFigure.toString() + " square: " + multiAngleFigure.getSquare());
        LOGGER.log(Level.INFO, multiAngleFigure.toString() + " perimeter: " + multiAngleFigure.getSquare());
        LOGGER.log(Level.DEBUG, "finish application");
    }

    public static TaskSecond getInstance() {
        if (instance == null) {
            instance = new TaskSecond();
        }
        return instance;
    }

}
