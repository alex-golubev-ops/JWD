package com.golubev.jwd.topicfirst.app;

import com.golubev.jwd.topicfirst.decorator.FigureFigureDecorator;
import com.golubev.jwd.topicfirst.decorator.postprocessors.api.CheckExistPostProcessor;
import com.golubev.jwd.topicfirst.decorator.postprocessors.model.PostProcessor;
import com.golubev.jwd.topicfirst.decorator.preprocessors.api.CheckPointsPreProcessor;
import com.golubev.jwd.topicfirst.decorator.preprocessors.model.PreProcessor;
import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.exception.FigureNotExistException;
import com.golubev.jwd.topicfirst.model.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public final class TaskSecond {
    private final Logger LOGGER = LogManager.getLogger(TaskSecond.class);
    private static TaskSecond instance;
    private Figure square;
    private Figure triangle;
    private Figure multiAngleFigure;
    private Factory factory = new FigureFigureDecorator(FigureFactory.getInstance(),
            new ArrayList<PostProcessor>(Arrays.asList(new CheckExistPostProcessor())),
            new ArrayList<PreProcessor>(Arrays.asList(new CheckPointsPreProcessor())));

    private TaskSecond() {

        try {
            square = factory.createFigure(FigureType.SQUARE, new ArrayList<Point>(Arrays.asList(new Point(2, 1),
                    new Point(4, 1), new Point(4, 3), new Point(2, 3))));

            triangle = factory.createFigure(FigureType.TRIANGLE, new ArrayList<Point>(Arrays.asList(new Point(1, 1),
                    new Point(2, 1), new Point(2, 3))));

            multiAngleFigure = factory.createFigure(FigureType.MULTI_ANGLE_FIGURE, new ArrayList<Point>(
                    Arrays.asList(new Point(3, 2),
                    new Point(5, 2), new Point(7, 4),
                    new Point(9, 4), new Point(9, 6),
                    new Point(3, 6))));

        } catch (FigureException e) {
            e.printStackTrace();
        }
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
        } catch (FigureNotExistException e) {
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
