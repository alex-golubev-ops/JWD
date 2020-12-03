package com.golubev.topicfirst.strategy;

import com.golubev.topicfirst.exception.FigureNotExistException;

public interface FigurePropertiesStrategy {
    double perimeter() throws FigureNotExistException;
    double square() throws FigureNotExistException;
}
