package sprint04;

public class Sprint04 {
    /*
    Create a Pet class with public fields name of type String and age of type int that are not initialized.
     */
    public class Pet {
        public String name;
        public int age;
    }

    /*
    Suppose we have the next class:
    class Employee {
        public String fullName;
        public float salary;
    }
    1. Create an instances of Employee class named 'emp1' and 'emp2'.
    2. Set values for 'fullName' and 'salary' properties.
    3. Create array of Employee type with name 'employees' and add two objects created before.
    4. Create variable with name 'employeesInfo' of String type.
    5. Using a loop, iterrate across array and write to variable named 'employeesInfo' info about each employee in next fommat:
     */
    void solution() {
        Employee emp1 = new Employee();
        emp1.fullName = "Linda";
        emp1.salary = 100f;
        Employee emp2 = new Employee();
        emp2.fullName = "Jack";
        emp2.salary = 120f;

        Employee[] employees = new Employee[2];
        employees[0] = emp1;
        employees[1] = emp2;

        String employeesInfo = "[";
        for (int i = 0; i < employees.length; i++) {
            employeesInfo += "{fullName: \"" + employees[i].fullName + "\", salary: " + employees[i].salary + "}";
            if (i != employees.length - 1) {
                employeesInfo += ", ";
            }
        }
        employeesInfo += "]";
    }

    /*
    Suppose we have the next class:
    class Employee {
        public String fullName;
        public float salary;
    }

    Create a new version of the Employee class that correspond next principles:
        1. All class fields must be private.
        2. Get and set methods must be used to access the class fields.
        3. The class must have a constructors with and without parameters.
     */
    class Employee {
        private String fullName;
        private float salary;

        public Employee() {
        }

        public Employee(String fullName, float salary) {
            this.fullName = fullName;
            this.salary = salary;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public float getSalary() {
            return salary;
        }

        public void setSalary(float salary) {
            this.salary = salary;
        }
    }

    /*
    Suppose we have the next class:
    class Circle {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public void draw() {

        }
    }

    Create a new version of the Circle class where the draw method will be overloaded three times:
        1. Using the one parameter color of String type.
        2. Using the one parameter scale of float type.
        3. Using two parameters color and scale of String and float type.
     */
    class Circle {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public void draw() {

        }

        public void draw(String color) {

        }

        public void draw(float scale) {

        }

        public void draw(String color, float scale) {

        }
    }

    /*
    Create the Point class that correspond next class diagram:

    Point class

    A Point class, which models a 2D point with x and y coordinates should contains:
        1. Two private instance variables x and y  of int type.
        2. A constructor that constructs a point with the given x and y coordinates.
        3. A method getXYPair() which returns the x and y in a 2-element int array.
        4. A method called distance(int x, int y) that returns the distance from this point to another point at the given (x, y) coordinates.
        5. An overloaded distance(Point point) method that returns the distance from this point to the given Point instance.
        6. Another overloaded distance() method that returns the distance from this point to the origin (0, 0).
     */
    public class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int[] getXYPair() {
            return new int[]{x, y};
        }

        /**
         * @return distance from this point to the given point at (x,y)
         */
        public double distance(int x, int y) {
            return distance(this.x, this.y, x, y);
        }

        /**
         * @return distance from this point to the given instance of Point
         */
        public double distance(Point point) {
            return distance(point.x, point.y);
        }

        /**
         * @return distance from this point to the origin (0,0)
         */
        public double distance() {
            return distance(0, 0);
        }

        /**
         * @return distance between two points (x1,y1) and (x2,y2)
         */
        private double distance(int x1, int y1, int x2, int y2) {
            return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        }
    }
}
