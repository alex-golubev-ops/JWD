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
        if (figure.check()) {
          return figure;
        }
        LOGGER.log(Level.ERROR, this.toString() + "is not exist ");
        throw new FigureException(toString()+"is not exist ");
    }

}
