package com.golubev.jwd.topicfirst.service;

import com.golubev.jwd.topicfirst.builder.Criterion;
import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.exception.FigureNotExistException;
import com.golubev.jwd.topicfirst.model.Figure;
import com.golubev.jwd.topicfirst.model.FigureType;
import com.golubev.jwd.topicfirst.model.Point;

import java.util.List;
import java.util.Optional;

public interface FigureCrud {
    void create( FigureType figureType, List<Point> points) throws FigureException;
    void multiCreate(List<Point>... points) throws FigureException;
    void delete(int id);
    Optional<Figure> find(int counterUngles) ;
    void update(int id, List<Point> points);
    Optional<Figure> findById(int id);
    Optional<Figure> findByCriterion(Criterion criterion) throws FigureNotExistException;

}
