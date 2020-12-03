package com.golubev.topicfirst.model;

import com.golubev.topicfirst.exception.FigureException;
import com.golubev.topicfirst.service.FigurePostProcessor;
import com.golubev.topicfirst.service.iml.FigureExistencePostProcessor;

public final class FigureFactory implements Factory {
    private static FigureFactory instance = new FigureFactory();
    private FigurePostProcessor processor = new FigureExistencePostProcessor();
    private FigureFactory(){

    }
    @Override
    public Square getSquare(Point[] points) throws FigureException {
        return (Square) processor.process(new Square(points));
    }

    @Override
    public Triangle getTriangle(Point[] points) throws FigureException {
        return (Triangle) processor.process(new Triangle(points));
    }

    @Override
    public MultiAngleFigure getMultiAngleFigure(Point[] points) throws FigureException {
        return (MultiAngleFigure) processor.process(new MultiAngleFigure(points));
    }

    public static FigureFactory getInstance(){
        return instance;
    }
}
