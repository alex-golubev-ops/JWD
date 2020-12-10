package com.golubev.jwd.topicfirst.decorator.preprocessors.api;

import com.golubev.jwd.topicfirst.decorator.preprocessors.model.PreProcessor;
import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.model.Point;

import java.util.List;

public class CheckPointsPreProcessor implements PreProcessor {
    @Override
    public void process(List<Point> points) throws FigureException {
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (points.get(i).equals(points.get(j))) {
                    throw new FigureException("Figure is not exist, because have two same points");
                }
            }
        }

    }
}
