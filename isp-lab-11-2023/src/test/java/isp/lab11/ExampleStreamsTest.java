package isp.lab11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleStreamsTest {
    static List<ExampleStreams.Person> persons = new ArrayList<>();

    @BeforeAll
    public static void init() {
        persons.add(new ExampleStreams.Person("John", "Thomson", 25, true, 1200));
        persons.add(new ExampleStreams.Person("Olivia", "Harris", 18, false, 0));
        persons.add(new ExampleStreams.Person("Lucas", "Scott", 35, true, 1100));
        persons.add(new ExampleStreams.Person("Olivia", "Lee", 20, false, 0));
        // Add more persons as needed
    }

    @Test
    public void testFindEmployedPersons() {
        List<ExampleStreams.Person> employedPersons = ExampleStreams.findEmployedPersons(persons);
        assertEquals(2, employedPersons.size());
    }

    @Test
    public void testFindAllPersonsByLastName() {
        List<ExampleStreams.Person> personsByLastName = ExampleStreams.findAllPersonsByLastName(persons, "Lee");
        assertEquals(1, personsByLastName.size());
    }

    @Test
    public void testFindTheFirstPersonByFirstName() {
        ExampleStreams.Person person = ExampleStreams.findFirstPersonByFirstName(persons, "Olivia");
        assertNotNull(person);
        assertEquals("Harris", person.getLastName());
    }

    @Test
    public void testGetUniqueFirstNames() {
        Set<String> uniqueFirstNames = ExampleStreams.getUniqueFirstNames(persons);
        assertEquals(3, uniqueFirstNames.size());
    }

    @Test
    public void testCalculateAverageSalary() {
        double averageSalary = ExampleStreams.calculateAverageSalary(persons);
        assertEquals(1150, averageSalary);
    }

    @Test
    public void testCalculateAverageAge() {
        double averageAge = ExampleStreams.calculateAverageAge(persons);
        assertEquals(19, averageAge); // Adjust expected value based on the persons you added
    }

    @Test
    public void testGroupByEmploymentStatus() {
        Map<Boolean, List<ExampleStreams.Person>> grouped = ExampleStreams.groupByEmploymentStatus(persons);
        assertEquals(2, grouped.get(true).size());
        assertEquals(2, grouped.get(false).size());
    }

    @Test
    public void testGroupByFirstName() {
        Map<String, List<ExampleStreams.Person>> grouped = ExampleStreams.groupByFirstName(persons);
        assertEquals(1, grouped.get("John").size());
        assertEquals(2, grouped.get("Olivia").size());
        assertEquals(1, grouped.get("Lucas").size());
    }

    @Test
    public void testLists() {
        List<String> l1 = List.of("1", "2", "3");
        List<String> l2 = List.of("1", "2", "3");
        List<String> l3 = List.of("2", "3", "1");

        assertEquals(l1, l2, "the lists are not equal");
        assertNotSame(l1, l2, "the lists are the same");
        assertNotEquals(l1, l3, "the lists are equal");
    }
}
