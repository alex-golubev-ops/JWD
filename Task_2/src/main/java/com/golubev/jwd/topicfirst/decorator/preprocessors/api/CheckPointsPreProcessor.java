package com.golubev.jwd.topicfirst.decorator.preprocessors.api;

import com.golubev.jwd.topicfirst.decorator.preprocessors.model.PreProcessor;
import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.model.Point;

public class CheckPointsPreProcessor implements PreProcessor {
    @Override
    public void process(Point[] points) throws FigureException {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    throw new FigureException("Figure is not exist, because have two same points");
                }
            }
        }

    }
}
