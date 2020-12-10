package com.golubev.jwd.topicfirst.model;

import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.factory.FigureFactory;

import java.util.List;

public final class SimpleFigureFactory implements FigureFactory {
    private static SimpleFigureFactory instance;
    private SimpleFigureFactory(){

    }
    public SimpleFigureFactory getInstance(){
        if(instance==null){
            instance = new SimpleFigureFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(FigureType type, List<Point> figureConstituents) throws FigureException {
        switch (type){
            case SQUARE: {
                return new Square(figureConstituents);
            }
            case TRIANGLE:{
                return new Triangle(figureConstituents);
            }
            case MULTI_ANGLE_FIGURE:{
                return new MultiAngleFigure(figureConstituents);
            }
            default: throw new FigureException("This figure is does not exist");
        }
    }

}
