package com.golubev.topicfirst.service;

import com.golubev.topicfirst.exception.FigureException;
import com.golubev.topicfirst.model.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}
