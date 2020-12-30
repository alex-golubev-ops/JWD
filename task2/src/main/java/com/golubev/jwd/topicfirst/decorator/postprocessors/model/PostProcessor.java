package com.golubev.jwd.topicfirst.decorator.postprocessors.model;

import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.model.Figure;
import com.golubev.jwd.topicfirst.model.FigureType;

public interface PostProcessor {
    Figure process(FigureType type, Figure figure) throws FigureException;
}
