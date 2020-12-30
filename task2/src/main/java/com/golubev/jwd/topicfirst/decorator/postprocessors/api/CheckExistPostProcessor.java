package com.golubev.jwd.topicfirst.decorator.postprocessors.api;

import com.golubev.jwd.topicfirst.decorator.postprocessors.model.PostProcessor;
import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.exception.FigureNotExistException;
import com.golubev.jwd.topicfirst.model.Figure;
import com.golubev.jwd.topicfirst.model.FigureType;
import com.golubev.jwd.topicfirst.model.Line;

import java.util.List;

public class CheckExistPostProcessor implements PostProcessor {
    @Override
    public Figure process(FigureType type, Figure figure) throws FigureException {
        switch (type) {
            case MULTI_ANGLE_FIGURE: {
                return figure;

            }
            case TRIANGLE: {
                List<Double> lines = Line.getLines(figure.getPoints());
                if (lines.get(0) + lines.get(1) <= lines.get(2) ||
                        lines.get(1) + lines.get(2) <= lines.get(0) ||
                        lines.get(2) + lines.get(0) <= lines.get(1)
                ) {
                    throw new FigureNotExistException("Triangle can't exist");
                }
                return figure;

            }
            case SQUARE: {
                List<Double> lines = Line.getLines(figure.getPoints());
                double line = lines.get(0);
                for (Double aDouble : lines) {
                    if (line != aDouble) {
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
