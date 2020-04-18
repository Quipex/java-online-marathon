package sprint06;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sprint06.Sprint06Task2.*;

class Sprint06Task2Test {
    /*
    Create classes Employee (fields String name, int experience and BigDecimal basePayment) and
        Manager (field double coefficient) with methods which return the general working experience and
        payment for work done.
    A getter methods of class Employee return value of all fields: getName(), getExperience() and getPayment().
    Classes Manager is derived from class Employee and override getPayment() method
        to return multiplication of a coefficient and base payment.
    Create a largestEmployees() method of the MyUtils class to return a List of unique employees with
        maximal working experience and payment without duplicate objects.

    The original list must be unchanged.

    For example, for a given list
    [Employee [name=Ivan, experience=10, basePayment=3000.00],
        Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
        Employee [name=Stepan, experience=8, basePayment=4000.00],
        Employee [name=Andriy, experience=7, basePayment=3500.00],
        Employee [name=Ihor, experience=5, basePayment=4500.00],
        Manager [name=Vasyl, experience=8, basePayment=2000.00, coefficient=2.0]]
    you should get
    [Employee [name=Ivan, experience=10, basePayment=3000.00],
        Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
        Employee [name=Ihor, experience=5, basePayment=4500.00]].
     */
    @Test
    public void test() {
        Employee[] expected = new Employee[]{
                new Employee("Ivan", 10, new BigDecimal(3000)),
                new Manager("Petro", 9, new BigDecimal(3000), 1.5),
                new Employee("Ihor", 5, new BigDecimal(4500))
        };

        Employee[] testSet = new Employee[]{
                new Employee("Ivan", 10, new BigDecimal(3000)),
                new Manager("Petro", 9, new BigDecimal(3000), 1.5),
                new Employee("Stepan", 8, new BigDecimal(4000)),
                new Employee("Andriy", 7, new BigDecimal(3500)),
                new Employee("Ihor", 5, new BigDecimal(4500)),
                new Manager("Vasyl", 8, new BigDecimal(2000), 2.0),
        };

        List<Employee> result = MyUtils.largestEmployees(Arrays.asList(testSet));
        assertEquals(Arrays.asList(expected), result);
    }

}
