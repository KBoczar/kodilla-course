package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        return (n >= 0 && n < shapes.size()) ? shapes.get(n) : null;
    }

    public String showFigures() {
        List<String> shapeNames = new ArrayList<>();
        for (Shape shape : shapes) {
            shapeNames.add(shape.getShapeName());
        }
        return String.join(", ", shapeNames);
    }

    public int getFiguresCount() {
        return shapes.size();
    }
}
