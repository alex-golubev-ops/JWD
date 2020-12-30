package com.golubev.jwd.topicfirst.app;

import com.golubev.jwd.topicfirst.builder.Builder;
import com.golubev.jwd.topicfirst.builder.BuilderCriterion;
import com.golubev.jwd.topicfirst.builder.Criterion;
import com.golubev.jwd.topicfirst.decorator.FigureFigureDecorator;
import com.golubev.jwd.topicfirst.decorator.postprocessors.api.CheckExistPostProcessor;
import com.golubev.jwd.topicfirst.decorator.postprocessors.model.PostProcessor;
import com.golubev.jwd.topicfirst.decorator.preprocessors.api.CheckPointsPreProcessor;
import com.golubev.jwd.topicfirst.decorator.preprocessors.model.PreProcessor;
import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.model.*;
import com.golubev.jwd.topicfirst.service.FigureCrud;
import com.golubev.jwd.topicfirst.service.iml.FigureCrudIml;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TaskThird {
    private final Logger LOGGER = LogManager.getLogger(TaskSecond.class);
    private static TaskThird instance;
    private Factory factory = new FigureFigureDecorator(FigureFactory.getInstance(),
            new ArrayList<PostProcessor>(Arrays.asList(new CheckExistPostProcessor())),
            new ArrayList<PreProcessor>(Arrays.asList(new CheckPointsPreProcessor())));


    public void run() {
        try {
            LOGGER.log(Level.DEBUG, "start application");
            FigureCrud figureCrud = new FigureCrudIml();
            List<Point> points = new ArrayList<>(Arrays.asList(
                    new Point(2, 3),
                    new Point(6, 3),
                    new Point(4, 6)));

            figureCrud.create(FigureType.TRIANGLE, points);
            LOGGER.log(Level.INFO, "add triangle");
            points = new ArrayList<>(Arrays.asList(
                    new Point(2, 3),
                    new Point(5, 3),
                    new Point(5, 6),
                    new Point(2, 6)));
            figureCrud.create(FigureType.SQUARE, points);
            LOGGER.log(Level.INFO, "add square");
            Optional<Figure> figure = figureCrud.findById(2);
            LOGGER.log(Level.INFO, "Found figure " + figure.get());
            Builder builder = new BuilderCriterion();
            builder.setPerimeter(12);
            builder.setSquare(9);
            Criterion criterion = builder.create();
            Optional<Figure> byCriterion = figureCrud.findByCriterion(criterion);
            LOGGER.log(Level.INFO, "found figure to the criterion " + byCriterion.get());
            LOGGER.log(Level.DEBUG, "finish application");
        } catch (FigureException e) {
            e.printStackTrace();
        }
    }

    public static TaskThird getInstance() {
        if (instance == null) {
            instance = new TaskThird();
        }
        return instance;
    }
}
