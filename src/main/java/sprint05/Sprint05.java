package sprint05;

import java.time.LocalDate;

public class Sprint05 {
    /*
    Create the abstract base class Employee with protected string variable employeelD and public getFullInfo() method without an implementation.
    Create public constructor with one string parameter for this class.
    Create two classes SalariedEmployee and ContractEmployee, which are inherited from the Employee class.

     • Describe protected string field socialSecurityNumber in the class SalariedEmployee.
     • Include a description of string protected federalTaxIDMember field in the class of ContractEmployee.
     • Describe constructors with two parameters for ContractEmployee class and for SalariedEmployee class for initializing corresponding fields.
     • getFullInfo should return String containing:
        • employeelD and socialSecurityNumber for SalariedEmployee
        • employeelD and federalTaxIDMember for ContractEmployee
     */

    abstract class Employee {
        protected String employeeID;

        public abstract String getFullInfo();

        public Employee(String employeeID) {
            this.employeeID = employeeID;
        }
    }

    class SalariedEmployee extends Employee {
        protected String socialSecurityNumber;

        public SalariedEmployee(String employeeID, String socialSecurityNumber) {
            super(employeeID);
            this.socialSecurityNumber = socialSecurityNumber;
        }

        @Override
        public String getFullInfo() {
            return employeeID + ", " + socialSecurityNumber;
        }
    }

    class ContractEmployee extends Employee {
        protected String federalTaxIDMember;

        public ContractEmployee(String employeeID, String federalTaxIDMember) {
            super(employeeID);
            this.federalTaxIDMember = federalTaxIDMember;
        }

        @Override
        public String getFullInfo() {
            return employeeID + ", " + federalTaxIDMember;
        }
    }

    /*
    •Implement class User with protected fields name, surname and public method getFullName() which returns name and
        surname with one space between them. Constructor of User define as public with two parameters – for initialization name and surname
    •Implement also class Student that is inherited from User. This class must have integer protected field year – the year
        of entering university, and public method getCourseNumber() – evaluates year of studying based on year property
        and current year: the difference between years + 1. (If the value is not from the range from 1 to 6, the metod
        should return -1). Conctructor of Student should be public and have 3 parameters: year, name and surname and
        pass name and surname to the base class. (year parameter should be the first.)
     */

    public static class User {
        protected String name;
        protected String surname;

        public User(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getFullName() {
            return name + " " + surname;
        }
    }

    public static class Student extends User {
        /**
         * the year of entering university
         */
        protected int year;

        public Student(int year, String name, String surname) {
            super(name, surname);
            this.year = year;
        }

        /**
         * @return year of studying based on year property
         * and current year: the difference between years + 1.
         * (If the value is not from the range from 1 to 6, the method should return -1).
         */
        public int getCourseNumber() {
            int nowYear = LocalDate.now().getYear();
            int years = nowYear - year;
            if (years < 1 || years > 6) {
                return -1;
            } else {
                return years;
            }
        }
    }

    /*
    Create class Animal with fields age (int) and weight (double) that can be accessed in the same package only.
    Animal should have method move without implementation, accessible from everywhere in the application.
    Animal should have a public constructor with parameters age and weight for initialization corresponding fields.

    Create Descendant classes Mammal, Fish, and Bird.
    For Mammal method move returns "run", for Fish - "swim", for Bird - "fly".
    Make it impossible to create descendants of Fish and Bird.
    Forbid overriding method move for Mammal.
     */
    abstract class Animal {
        int age;
        double weight;

        public abstract String move();

        public Animal(int age, double weight) {
            this.age = age;
            this.weight = weight;
        }
    }

    class Mammal extends Animal {

        public Mammal(int age, double weight) {
            super(age, weight);
        }

        @Override
        public final String move() {
            return "run";
        }
    }

    final class Fish extends Animal {

        public Fish(int age, double weight) {
            super(age, weight);
        }

        @Override
        public String move() {
            return "swim";
        }
    }

    final class Bird extends Animal {

        public Bird(int age, double weight) {
            super(age, weight);
        }

        @Override
        public String move() {
            return "fly";
        }
    }

    /*
    Please, make refactoring of the code:

    class Person{
        String childIDNumber;
    }

    class Child{
        int age;
        String healthInfo;
        String name;
        String getHealthStatus(){ return name +" " + healthInfo; }
    }

    class Adult{
        int age;
        String healthInfo;
        String passportNumber;
        String name;
        String getHealthStatus(){ return name +" " + healthInfo; }
    }

    We know that adult  doesn't have childIDNumber
    child doesn't have passportNumber.

    Create a public constructor in each class to initialize all their fields (make the first parameter of type int).
     */

    static class Person {
        int age;
        String name;
        String healthInfo;

        public Person(int age, String name, String healthInfo) {
            this.age = age;
            this.name = name;
            this.healthInfo = healthInfo;
        }

        String getHealthStatus() {
            return name + " " + healthInfo;
        }
    }

    static class Child extends Person {
        String childIDNumber;

        public Child(int age, String name, String healthInfo, String childIDNumber) {
            super(age, name, healthInfo);
            this.childIDNumber = childIDNumber;
        }
    }

    static class Adult extends Person {
        String passportNumber;

        public Adult(int age, String name, String healthInfo, String passportNumber) {
            super(age, name, healthInfo);
            this.passportNumber = passportNumber;
        }
    }
}
