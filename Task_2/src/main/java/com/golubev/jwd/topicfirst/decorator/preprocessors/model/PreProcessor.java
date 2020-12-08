package com.golubev.jwd.topicfirst.decorator.preprocessors.model;

import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.model.Point;

public interface PreProcessor {
    void process(Point[] points) throws FigureException;
}
