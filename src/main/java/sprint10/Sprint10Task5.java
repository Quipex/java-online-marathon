package sprint10;

import java.util.Arrays;
import java.util.Comparator;

public class Sprint10Task5 {
    static class Person {
        protected String name;
        protected int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Age: " + age;
        }
    }

    static class Employee extends Person {
        private double salary;

        public Employee(String name, int age, double salary) {
            super(name, age);
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return super.toString() + ", Salary: " + salary;
        }
    }

    static class Developer extends Employee {
        private Level level;

        public Developer(String name, int age, double salary, Level level) {
            super(name, age, salary);
            this.level = level;
        }

        public Level getLevel() {
            return level;
        }

        @Override
        public String toString() {
            return super.toString() + ", Level: " + level.name();
        }
    }

    enum Level {
        JUNIOR, MIDDLE, SENIOR
    }

    // Write PersonComparator, EmployeeComparator and DeveloperComparator here
    class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person our, Person their) {
            int nameCompared = our.getName().compareTo(their.getName());
            if (nameCompared != 0) {
                return nameCompared;
            } else {
                return Integer.compare(our.getAge(), their.getAge());
            }
        }
    }

    class EmployeeComparator implements Comparator<Employee> {
        private final PersonComparator personComparator = new PersonComparator();

        @Override
        public int compare(Employee our, Employee their) {
            int peopleCompared = personComparator.compare(our, their);
            if (peopleCompared != 0) {
                return peopleCompared;
            } else {
                return Double.compare(our.getSalary(), their.getSalary());
            }
        }
    }

    class DeveloperComparator implements Comparator<Developer> {
        private final EmployeeComparator employeeComparator = new EmployeeComparator();

        @Override
        public int compare(Developer our, Developer their) {
            int employeesCompared = employeeComparator.compare(our, their);
            if (employeesCompared != 0) {
                return employeesCompared;
            } else {
                return our.getLevel().compareTo(their.getLevel());
            }
        }
    }

    static class Utility {
        public static <T extends Person> void sortPeople(T[] array, Comparator<? super Object> comparator) {
            Arrays.sort(array, comparator);
        }
    }
}
