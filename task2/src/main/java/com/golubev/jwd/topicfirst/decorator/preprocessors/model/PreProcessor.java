package com.golubev.jwd.topicfirst.decorator.preprocessors.model;

import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.model.Point;

import java.util.List;

public interface PreProcessor {
    void process(List<Point> points) throws FigureException;
}
