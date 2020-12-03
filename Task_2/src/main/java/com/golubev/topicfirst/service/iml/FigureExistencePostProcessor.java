package com.golubev.topicfirst.service.iml;

import com.golubev.topicfirst.exception.FigureException;
import com.golubev.topicfirst.model.Figure;
import com.golubev.topicfirst.model.Line;
import com.golubev.topicfirst.service.FigurePostProcessor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class FigureExistencePostProcessor implements FigurePostProcessor {
    private final Logger LOGGER = LogManager.getLogger(FigurePostProcessor.class);
    @Override
    public Figure process(Figure figure) throws FigureException {
        if (checkPoints(figure)) {
            LOGGER.log(Level.ERROR, this.toString() + " is not exist");
            throw new FigureException(this.toString()+" is not exist ");
        }
        double[] lines = checkLines(figure);
        if (lines[0] == lines[3] && lines[4] == lines[5]) {
            return figure;
        }
        LOGGER.log(Level.ERROR, this.toString() + "is not exist ");
        throw new FigureException(toString()+"is not exist ");
    }

    private boolean checkPoints(Figure figure) {
        for (int i = 0; i < figure.getPoints().length - 1; i++) {
            for (int j = i + 1; j < figure.getPoints().length; j++) {
                if (figure.getPoints()[i].equals(figure.getPoints()[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private double[] checkLines(Figure figure) {
        double[] array = new double[6];
        int k = 0;
        for (int i = 0; i < figure.getPoints().length - 1; i++) {
            for (int j = i + 1; j < figure.getPoints().length; j++) {
                array[k] = Line.modul(figure.getPoints()[i],figure.getPoints()[j]);
                k++;
            }
        }
        Arrays.sort(array);
        return array;
    }
}
