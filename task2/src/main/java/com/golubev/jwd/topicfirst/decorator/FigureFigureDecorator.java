package com.golubev.jwd.topicfirst.decorator;

import com.golubev.jwd.topicfirst.decorator.postprocessors.model.PostProcessor;
import com.golubev.jwd.topicfirst.decorator.preprocessors.model.PreProcessor;
import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.model.Factory;
import com.golubev.jwd.topicfirst.model.Figure;
import com.golubev.jwd.topicfirst.model.FigureType;
import com.golubev.jwd.topicfirst.model.Point;

import java.util.ArrayList;
import java.util.List;

public class FigureFigureDecorator implements Factory {
    private Factory factory;

    public FigureFigureDecorator(Factory factory) {
        this.factory = factory;

    }

    public FigureFigureDecorator(Factory factory, List<? extends PostProcessor> postProcessors,
                                 List<? extends PreProcessor> preProcessors) {
        this.factory = factory;
        this.postProcessors = new ArrayList<>(postProcessors);
        this.preProcessors = new ArrayList<>(preProcessors);
    }

    private List<PostProcessor> postProcessors;
    private List<PreProcessor> preProcessors;

    public void addPostProcessors(PostProcessor postProcessor) {
        postProcessors.add(postProcessor);
    }

    public void setPreProcessors(PreProcessor preProcessor) {
        preProcessors.add(preProcessor);
    }

    @Override
    public Figure createFigure(FigureType type, List<Point> figureConstituents) throws FigureException {
        for (PreProcessor preProcessor : preProcessors) {
            preProcessor.process(figureConstituents);
        }
        Figure figure = factory.createFigure(type, figureConstituents);
        for (PostProcessor postProcessor : postProcessors) {
            postProcessor.process(type, figure);
        }
        return figure;
    }
}
