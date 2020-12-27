package com.golubev.jwd.topicfirst.service.iml;

import com.golubev.jwd.topicfirst.builder.Criterion;
import com.golubev.jwd.topicfirst.exception.FigureException;
import com.golubev.jwd.topicfirst.exception.FigureNotExistException;
import com.golubev.jwd.topicfirst.model.*;
import com.golubev.jwd.topicfirst.service.FigureCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FigureCrudIml implements FigureCrud {
    private static FigureCrudIml instance;
    private int id = 0;
    private Factory factory;

    private List<Figure> figuresCrud;

    public FigureCrudIml() {
        figuresCrud = new ArrayList<>();
        factory = FigureFactory.getInstance();
    }

    public static FigureCrudIml getInstance() {
        if (instance == null) {
            instance = new FigureCrudIml();
        }
        return instance;
    }


    @Override
    public void create(FigureType figureType, List<Point> points) throws FigureException {
        Figure figure = factory.createFigure(figureType, points);
        figuresCrud.add(figure);
        id++;
    }

    @Override
    public void multiCreate(List<Point>... points) throws FigureException {
        Figure figure = null;
        for (List<Point> point : points) {
            if (point.size() < 3) {
                throw new FigureException("This figure is not exist");
            }
            if (point.size() == 3) {
                figure = factory.createFigure(FigureType.TRIANGLE, point);
            } else if (point.size() == 4) {
                figure = factory.createFigure(FigureType.SQUARE, point);
            } else {
                figure = factory.createFigure(FigureType.MULTI_ANGLE_FIGURE, point);
            }
            figuresCrud.add(figure);
            id++;
        }

    }

    @Override
    public void delete(int id) {
        figuresCrud.remove(id - 1);
    }

    @Override
    public Optional<Figure> find(int counterUngles) {
        for (Figure figure : figuresCrud) {
            if (figure.getPoints().size() == counterUngles) {
                return Optional.of(figure);
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(int id, List<Point> points) {
        Figure figure = figuresCrud.get(id - 1);
        figure.setPoints(points);
    }

    @Override
    public Optional<Figure> findById(int id) {
        return Optional.ofNullable(figuresCrud.get(id - 1));
    }

    @Override
    public Optional<Figure> findByCriterion(Criterion criterion) throws FigureNotExistException {
        for (Figure figure : figuresCrud) {
            if (figure.getSquare() == criterion.getSquare() &&
                    figure.getPerimeter() == criterion.getPerimeter()) {
                return Optional.ofNullable(figure);
            }
        }
        return Optional.empty();
    }
}
