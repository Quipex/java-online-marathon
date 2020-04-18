package sprint06;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Sprint06Task1 {
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

    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int occupationYears() {
            return -1;
        }

        public String occupationPlace() {
            return null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    static class Student extends Person {
        private String studyPlace;
        private int studyYears;

        public Student(String name, String studyPlace, int studyYears) {
            super(name);
            this.studyPlace = studyPlace;
            this.studyYears = studyYears;
        }

        public String getStudyPlace() {
            return studyPlace;
        }

        public int getStudyYears() {
            return studyYears;
        }

        @Override
        public String occupationPlace() {
            return studyPlace;
        }

        @Override
        public int occupationYears() {
            return studyYears;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Student student = (Student) o;
            return studyYears == student.studyYears &&
                    Objects.equals(studyPlace, student.studyPlace);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), studyPlace, studyYears);
        }
    }

    static class Worker extends Person {
        private String workPosition;
        private int experienceYears;

        public Worker(String name, String workPosition, int experienceYears) {
            super(name);
            this.workPosition = workPosition;
            this.experienceYears = experienceYears;
        }

        public String getWorkPosition() {
            return workPosition;
        }

        public int getExperienceYears() {
            return experienceYears;
        }

        @Override
        public String occupationPlace() {
            return workPosition;
        }

        @Override
        public int occupationYears() {
            return experienceYears;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Worker worker = (Worker) o;
            return experienceYears == worker.experienceYears &&
                    Objects.equals(workPosition, worker.workPosition);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), workPosition, experienceYears);
        }
    }

    public static class MyUtils {
        public static List<Person> maxDuration(List<Person> persons) {
            if (persons.isEmpty()) {
                return new ArrayList<>();
            }
            Map<Class<? extends Person>, List<Person>> personClassToMaxDurationPeople = new HashMap<>();
            for (Person person : persons) {
                if (person != null && person.occupationYears() >= 0) {
                    Class<? extends Person> personClass = person.getClass();
                    List<Person> maxDurPeople = personClassToMaxDurationPeople
                            .getOrDefault(personClass, new ArrayList<>());
                    updateListWithMaxDurationPeople(maxDurPeople, person);
                    personClassToMaxDurationPeople.put(personClass, maxDurPeople);
                }
            }
            return personClassToMaxDurationPeople.values().stream()
                    .flatMap(Collection::stream).collect(Collectors.toList());
        }

        private static void updateListWithMaxDurationPeople(List<Person> maxDurPeople, Person person) {
            int maxDuration = duration(maxDurPeople);
            if (person.occupationYears() > maxDuration) {
                maxDurPeople.clear();
            }
            if (person.occupationYears() >= maxDuration) {
                maxDurPeople.add(person);
            }
        }

        private static int duration(List<Person> personList) {
            if (personList.size() == 0) {
                return Integer.MIN_VALUE;
            } else {
                Person person = personList.get(0);
                return person.occupationYears();
            }
        }
    }
}
