package com.golubev.jwd.topicfirst.decorator;

import com.golubev.jwd.topicfirst.decorator.postprocessors.model.PostProcessor;
import com.golubev.jwd.topicfirst.decorator.preprocessors.model.PreProcessor;
import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.factory.FigureFactory;
import com.golubev.jwd.topicfirst.model.Factory;
import com.golubev.jwd.topicfirst.model.Figure;
import com.golubev.jwd.topicfirst.model.FigureType;
import com.golubev.jwd.topicfirst.model.Point;

public class FigureFigureDecorator implements Factory {
    private Factory factory;

    public FigureFigureDecorator(Factory factory) {
        this.factory = factory;
    }

    public FigureFigureDecorator(Factory factory, PostProcessor[] postProcessors, PreProcessor[] preProcessors) {
        this.factory = factory;
        this.postProcessors = postProcessors;
        this.preProcessors = preProcessors;
    }

    private PostProcessor[] postProcessors;
    private PreProcessor[] preProcessors;

    public void setPostProcessors(PostProcessor[] postProcessors) {
        this.postProcessors = postProcessors;
    }

    public void setPreProcessors(PreProcessor[] preProcessors) {
        this.preProcessors = preProcessors;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
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
