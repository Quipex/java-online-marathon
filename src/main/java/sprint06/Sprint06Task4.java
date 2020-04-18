package sprint06;

import java.util.*;
import java.util.stream.Collectors;

public class Sprint06Task4 {
    /*
    Please create class Shape with abstract method to calculate area of figure and field name.
    Replace code in method getArea() according to principles of polymorphism
    i.e. Circle and Rectangle classes extends Shape class and override double getArea() method.
    Develop maxAreas() method of the MyUtils class to return a List with instances of maximum area.

    The original list must be unchanged.
    For example, for a given list
    [Circle [radius=2.00], Rectangle [height=2.00, width=3.00], Circle [radius=1.00], Rectangle [height=3.00, width=2.00],  Circle [radius=0.50], Rectangle [height=1.00, width=2.00]]
    you should get
    [Circle [radius=2.00], Rectangle [height=2.00, width=3.00], Rectangle [height=3.00, width=2.00]]
     */
    static abstract class Shape {
        private String name;

        public Shape(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public abstract double getArea();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shape shape = (Shape) o;
            return Objects.equals(name, shape.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    static class Circle extends Shape {
        private double radius;

        public Circle(String name) {
            super(name);
        }

        public Circle(String name, double radius) {
            this(name);
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * Math.pow(radius, 2);
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "name='" + getName() + '\'' +
                    ", radius=" + radius +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Circle circle = (Circle) o;
            return Double.compare(circle.radius, radius) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), radius);
        }
    }

    static class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(String name) {
            super(name);
        }

        public Rectangle(String name, double width, double height) {
            super(name);
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        @Override
        public double getArea() {
            return width * height;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "name='" + getName() + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Rectangle rectangle = (Rectangle) o;
            return Double.compare(rectangle.width, width) == 0 &&
                    Double.compare(rectangle.height, height) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), width, height);
        }
    }

    public static class MyUtils {
        public static List<Shape> maxAreas(List<Shape> shapes) {
            List<Shape> filteredShapes = shapes.stream()
                    .filter(Objects::nonNull).collect(Collectors.toList());
            if (filteredShapes.isEmpty()) {
                return new ArrayList<>();
            }
            Map<Class<? extends Shape>, List<Shape>> uniqueClassesToShapes = new HashMap<>();
            for (Shape consideredShape : filteredShapes) {
                Class<? extends Shape> shapeClass = consideredShape.getClass();
                List<Shape> accumulatedShapes = uniqueClassesToShapes.getOrDefault(shapeClass, new ArrayList<>());
                updateListWithMaxAreaShapes(accumulatedShapes, consideredShape);
                uniqueClassesToShapes.put(shapeClass, accumulatedShapes);
            }
            return uniqueClassesToShapes.values().stream()
                    .flatMap(Collection::stream).collect(Collectors.toList());
        }

        private static void updateListWithMaxAreaShapes(List<Shape> maxAreaShapes, Shape shape) {
            double maxArea = area(maxAreaShapes);
            if (shape.getArea() > maxArea) {
                maxAreaShapes.clear();
            }
            if (shape.getArea() >= maxArea) {
                maxAreaShapes.add(shape);
            }
        }

        private static double area(List<Shape> shapesList) {
            if (shapesList.size() == 0) {
                return Integer.MIN_VALUE;
            } else {
                return shapesList.get(0).getArea();
            }
        }
    }
}
