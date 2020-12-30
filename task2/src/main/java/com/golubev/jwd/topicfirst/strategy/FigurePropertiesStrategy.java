package com.golubev.jwd.topicfirst.strategy;

import com.golubev.jwd.topicfirst.exception.FigureNotExistException;

public interface FigurePropertiesStrategy {
    double perimeter() throws FigureNotExistException;
    double square() throws FigureNotExistException;
}
