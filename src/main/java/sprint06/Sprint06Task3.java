package sprint06;

import java.util.List;
import java.util.Objects;

public class Sprint06Task3 {
    /*
    Create classes Square and Rectang with method (double getPerimeter()) for calculating of perimeter.
    Find solution for avoiding of duplicate code.
    Create a double sumPerimeter(List<?> firures) method of the MyUtils class to return a sum perimeters of all figures.
    For example, for a given list
    [[Square [width=4.00], Square [width=5.00], Rectang [height=2.00, width=3.00]]
    you should get 46
     */

    class Rectang {
        private double length;
        private double width;

        public Rectang(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getPerimeter() {
            return 2 * length + 2 * width;
        }
    }

    class Square extends Rectang {
        public Square(double side) {
            super(side, side);
        }

        @Override
        public double getPerimeter() {
            return super.getPerimeter();
        }
    }

    public class MyUtils {
        public double sumPerimeter(List<Rectang> figures) {
            return figures.stream()
                    .filter(Objects::nonNull)
                    .mapToDouble(Rectang::getPerimeter).sum();
        }
    }
}
