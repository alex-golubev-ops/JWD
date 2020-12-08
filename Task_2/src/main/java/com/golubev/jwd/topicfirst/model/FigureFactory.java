package com.golubev.jwd.topicfirst.model;

import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.exception.FigureNotExistException;


public final class FigureFactory implements Factory {
    private static FigureFactory instance = new FigureFactory();

    private FigureFactory() {

    }

    public static FigureFactory getInstance() {
        return instance;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] points) throws FigureException {
        switch (type) {
            case SQUARE: {
                return new Square(points);
            }
            case TRIANGLE: {
                return new Triangle(points);
            }
            case MULTI_ANGLE_FIGURE: {
                return new MultiAngleFigure(points);
            }
            default:
                throw new FigureNotExistException("Not Exist");
        }
    }
}
