package com.golubev.topicfirst.model;

public final class FigureFactory implements Factory {
    private static FigureFactory instance = new FigureFactory();
    private FigureFactory(){

    }
    @Override
    public Square getSquare(Point[] points) {
        return new Square(points);
    }

    @Override
    public Triangle getTriangle(Point[] points) {
        return new Triangle(points);
    }

    @Override
    public MultiAngleFigure getMultiAngleFigure(Point[] points) {
        return new MultiAngleFigure(points);
    }

    public static FigureFactory getInstance(){
        return instance;
    }
}
