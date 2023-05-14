package isp.lab11;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Radu Miron
 * <p>
 * Run/implement each method from 1. to 8.
 * Implement unit tests for the methods from 1. to 8.
 */
public class ExampleStreams {
    private static final List<Person> PERSONS = new ArrayList<>();

    // loop through the persons in a given list
    private static void printPersonList(Collection<Person> persons) {
        persons.forEach(p -> System.out.println(p)); //<=> persons.forEach(System.out::println);
        // p is a Person form the list
    }

    // loop through the persons in a given list
    private static void printPersonMap(Map<?, List<Person>> personByCriteria) {
        personByCriteria.forEach((k, l) -> {
            System.out.println(k);
            l.forEach(System.out::println);
        });
    }

    // 1. find all the employed persons
    protected static List<Person> findEmployedPersons(List<Person> persons) {
        return persons.stream()
                .filter(p -> p.isEmployed()) // <=> .filter(Person::isEmployed)
                .collect(Collectors.toList());
    }

    // find the employed persons - met 2. implemented with anonymous classes
    protected static List<Person> findEmployedPersonsWithAnonymousClass(List<Person> persons) {

        Predicate<Person> thePredicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.isEmployed();
            }
        };

        return persons.stream()
                .filter(thePredicate)
                .collect(Collectors.toList());
    }

    // 2. find all the persons by last name
    protected static List<Person> findAllPersonsByLastName(List<Person> persons, String lastName) {
        return persons.stream()
                .filter(p -> lastName != null && lastName.equals(p.getLastName()))
                .collect(Collectors.toList());
    }

    // 3. find any person with the given first name
    protected static Person findFirstPersonByFirstName(List<Person> persons, String firstName) {
        return persons.stream()
                .filter(p -> firstName != null && firstName.equals(p.getFirstName()))
                .findFirst() // .findAny()
                .orElse(null);
    }

    // 4. Get a set of the first names from the persons list
    protected static Set<String> getUniqueFirstNames(List<Person> persons) {
        return persons.stream()
                .map(p -> p.getFirstName()) // .map(Person::getFirstName)
                .collect(Collectors.toSet());
    }

    // 5. Calculate the average salary of all employed persons
    protected static double calculateAverageSalary(List<Person> persons) {
        return persons.stream()
                .filter(p -> p.isEmployed()) // .filter(Person::isEmployed())
                .mapToInt(p -> p.getSalary())
                .average()
                .orElse(0);
    }

    // 6. TODO: Calculate the average age of all unemployed persons
    // 6. Calculate the average age of all unemployed persons
    protected static double calculateAverageAge(List<Person> persons) {
        return persons.stream()
                .filter(p -> !p.isEmployed())
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }


    // 7. group the persons by employed/unemployed collect to map
    public static Map<Boolean, List<Person>> groupByEmploymentStatus(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::isEmployed));
    }

    // 8. TODO: Group persons by first name
    // 8. Group persons by first name
    protected static Map<String, List<Person>> groupByFirstName(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getFirstName));
    }

    public static void main(String[] args) {
        initPersons();
        // TODO: Uncomment and run each of the following method calls at a time
//        printPersonList(findEmployedPersons(PERSONS));
//        printPersonList(findAllPersonsByLastName(PERSONS, "Lee"));
//        System.out.println(findFirstPersonByFirstName(PERSONS, "Chloe"));
//        getUniqueFirstNames(PERSONS).forEach(System.out::println);
//        System.out.println(calculateAverageSalary(PERSONS));
//        System.out.println(calculateAverageAge(PERSONS));
//        printPersonMap(groupByEmploymentStatus(PERSONS));
//        printPersonMap(groupByFirstName(PERSONS));
    }

    private static void initPersons() {
        PERSONS.add(new Person("John", "Thomson", 25, true, 1200));
        PERSONS.add(new Person("Olivia", "Harris", 18, false, 0));
        PERSONS.add(new Person("Lucas", "Scott", 35, true, 1100));
        PERSONS.add(new Person("Benjamin", "Lee", 15, false, 0));
        PERSONS.add(new Person("Chloe", "Green", 45, true, 2000));
        PERSONS.add(new Person("Lucas", "Patel", 38, true, 1700));
        PERSONS.add(new Person("Ava", "Lee", 14, false, 0));
        PERSONS.add(new Person("Chloe", "Lee", 48, true, 2300));
    }

    public static final class Person {
        private String firstName;
        private String lastName;
        private int age;
        private boolean employed;
        private int salary;

        public Person(String firstName, String lastName, int age, boolean employed, int salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.employed = employed;
            this.salary = salary;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isEmployed() {
            return employed;
        }

        public void setEmployed(boolean employed) {
            this.employed = employed;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }
}
