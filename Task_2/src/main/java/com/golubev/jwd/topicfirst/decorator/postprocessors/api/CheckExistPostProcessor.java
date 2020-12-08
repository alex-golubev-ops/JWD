package com.golubev.jwd.topicfirst.decorator.postprocessors.api;

import com.golubev.jwd.topicfirst.decorator.postprocessors.model.PostProcessor;
import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.exception.FigureNotExistException;
import com.golubev.jwd.topicfirst.model.Figure;
import com.golubev.jwd.topicfirst.model.FigureType;
import com.golubev.jwd.topicfirst.model.Line;

public class CheckExistPostProcessor implements PostProcessor {
    @Override
    public Figure process(FigureType type, Figure figure) throws FigureException {
        switch (type) {
            case MULTI_ANGLE_FIGURE: {
                return figure;

            }
            case TRIANGLE: {
                double[] lines = Line.getLines(figure.getPoints());
                if (lines[0] + lines[1] <= lines[2] ||
                        lines[1] + lines[2] <= lines[0] ||
                        lines[2] + lines[0] <= lines[1]
                ) {
                    throw new FigureNotExistException("Triangle can't exist");
                }
                return figure;

            }
            case SQUARE: {
                double[] lines = Line.getLines(figure.getPoints());
                double line = lines[0];
                for (int i = 0; i < lines.length; i++) {
                    if (line != lines[i]) {
                        throw new FigureNotExistException("Square can't exist");
                    }
                }
                return figure;

            }
            default: {
                throw new FigureException("Not exist");
            }
        }
    }


}
