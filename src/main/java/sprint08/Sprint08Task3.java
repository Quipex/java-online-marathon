package sprint08;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Sprint08Task3 {
    /*
        Suppose, we have class Person:

        class Person{
            String name;
            String surname;

            Person(String name, String surname){
                this.name = name;
                this.surname = surname;
            }
        }

        Please, add to class App static BinaryOperator field greetingOperator.

        greetingOperator should work with strings. It forms a new string as a result by the rule:
        "Hello " + parameter1 + " " + parameter2 + "!!!"

        Create a static method createGreetings that takes two parameters: List<Person> and BinaryOperator and
        generates List<String> as a result. We should be able to pass greetingOperator as a parameter here.
        Please, use the second parameter in creating the result.
         */
    class Person {
        String name;
        String surname;

        Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }
    }

    static BinaryOperator<String> greetingOperator = (str1, str2) -> "Hello " + str1 + " " + str2 + "!!!";

    static List<String> createGreetings(List<Person> people, BinaryOperator<String> binaryOperator) {
        return people.stream()
                .map(p -> binaryOperator.apply(p.name, p.surname))
                .collect(Collectors.toList());
    }
}
