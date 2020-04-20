package sprint06;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sprint06.Sprint06Task1.*;

class Sprint06Task1Test {

    /*
    Create next types: Person (field String name),
    Student (fields String studyPlace, int studyYears) and
    Worker (fields String workPosition, int experienceYears).
    Classes Student and Worker are derived from class Person. All classes have getters to return fields.

    Create a maxDuration() method of the MyUtils class to return a list of Students with maximum duration of study and
    Workers with maximum experience.

    For example, for a given list
    [Person [name=Ivan],
    Student [name=Petro, studyPlace=University, studyYears=3],
    Worker [name=Andriy, workPosition=Developer, experienceYears=12],
    Student [name=Stepan, studyPlace=College, studyYears=4],
    Worker [name=Ira, workPosition=Manager, experienceYears=8],
    Student [name=Ihor, studyPlace=University, studyYears=4]]
    you should get
    [Worker [name=Andriy, workPosition=Developer, experienceYears=12],
    Student [name=Stepan, studyPlace=College, studyYears=4],
    Student [name=Ihor, studyPlace=University, studyYears=4]]
     */
    @Test
    public void personsTest() {
        Person[] people = new Person[] {
                new Person("Ivan"),
                new Student("Petro", "University", 3),
                new Worker("Andriy", "Developer", 12),
                new Student("Stepan", "College", 4),
                new Worker("Ira", "Manager", 8),
                new Student("Ihor", "University", 4),
                null,
                new CoolWorker("Kile", "qwe", 0),
        };

        List<Person> actualPpl = MyUtils.maxDuration(Arrays.asList(people));

        Person[] expected = new Person[]{
                new Worker("Andriy", "Developer", 12),
                new Student("Stepan", "College", 4),
                new Student("Ihor", "University", 4),
                new CoolWorker("Kile", "qwe", 0)
        };

        assertEquals(Arrays.asList(expected), actualPpl);
    }

}
