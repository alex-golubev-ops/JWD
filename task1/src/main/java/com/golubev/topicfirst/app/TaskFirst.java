package com.golubev.topicfirst.app;

import com.golubev.topicfirst.model.Line;
import com.golubev.topicfirst.model.Point;
import com.golubev.topicfirst.model.Square;
import com.golubev.topicfirst.model.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

public final class TaskFirst {
    private final Logger LOGGER = LogManager.getLogger(TaskFirst.class);
    private Point[] points;
    private Line[] lines;
    private Triangle[] triangles;
    private Square[] squares;
    private static TaskFirst instance;

    private TaskFirst() {
        points = generationPoints(4);
        lines = generationLines(2);
        triangles = generationTriangles(2);
        squares = generationSqares(1);

    }

    private Point[] generationPoints(int counterGenerationPoints) {
        Point[] generationPoints = new Point[counterGenerationPoints];
        Random random = new Random();
        for (int i = 0; i < generationPoints.length; i++) {
            generationPoints[i] = new Point(random.nextInt(10), random.nextInt(10));
        }
        return generationPoints;
    }

    private Line[] generationLines(int counterGenerationLines) {
        Line[] generationLines = new Line[counterGenerationLines];
        for (int i = 0; i < generationLines.length; i++) {
            generationLines[i] = new Line(generationPoints(2));
        }
        return generationLines;
    }

    private Triangle[] generationTriangles(int counterGenerationTriangles) {
        Triangle[] generationTriangles = new Triangle[counterGenerationTriangles];
        for (int i = 0; i < generationTriangles.length; i++) {
            generationTriangles[i] = new Triangle(generationPoints(3));
        }
        return generationTriangles;
    }

    private Square[] generationSqares(int counterGenerationSquares) {
        Square[] generationSquares = new Square[counterGenerationSquares];
        for (int i = 0; i < generationSquares.length; i++) {
            generationSquares[i] = new Square(generationPoints(4));
        }
        return generationSquares;
    }

    private void informationPoints() {
        LOGGER.log(Level.DEBUG, "Show points");
        int k = 0;
        do {
            LOGGER.log(Level.INFO, points[k].toString());
            k++;
        } while (k < points.length);
    }

    private void informationLines() {
        LOGGER.log(Level.DEBUG, "Show lines");
        for (Line line : lines) {
            LOGGER.log(Level.INFO, line.toString());
        }
    }

    private void informationTriangles() {
        LOGGER.log(Level.DEBUG, "Show triangles");
        for (Triangle triangle : triangles) {
            if (triangle.check()) {
                System.out.println(triangle.toString());
            }
        }
    }

    private void informationSquares() {
        LOGGER.log(Level.DEBUG, "Show squares");
        for (Square square : squares) {
            if (square.check()) {
                System.out.println(square.toString());
            }
        }
    }

    public void run() {
        LOGGER.log(Level.DEBUG, "Start application");
        informationPoints();
        informationLines();
        informationTriangles();
        informationSquares();
        LOGGER.log(Level.DEBUG, "finish application");
    }

    public static TaskFirst getInstance() {
        if (instance == null) {
            instance = new TaskFirst();
        }
        return instance;
    }

}
