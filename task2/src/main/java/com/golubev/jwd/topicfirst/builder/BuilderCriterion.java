package com.golubev.jwd.topicfirst.builder;

public class BuilderCriterion implements Builder {
    private double square;
    private double perimeter;

    @Override
    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public Criterion create() {
        return new Criterion(square,perimeter);
    }

}
