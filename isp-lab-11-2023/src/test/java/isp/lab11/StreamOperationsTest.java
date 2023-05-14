package isp.lab11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamOperationsTest {

    @Test
    public void testLongestString() {
        List<String> strings = Arrays.asList("Java", "JavaScript", "Python", "C", "C++", "Kotlin");
        Optional<String> longestString = strings.stream()
                .max(Comparator.comparingInt(String::length));
        assertEquals("JavaScript", longestString.get());
    }

    @Test
    public void testSumOfEvenNumbers() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = integers.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(30, sum);
    }

    @Test
    public void testUppercaseStrings() {
        List<String> strings = Arrays.asList("Java", "JavaScript", "Python", "C", "C++", "Kotlin");
        List<String> uppercaseStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertTrue(uppercaseStrings.containsAll(Arrays.asList("JAVA", "JAVASCRIPT", "PYTHON", "C", "C++", "KOTLIN")));
    }

    @Test
    public void testGroupedStrings() {
        List<String> strings = Arrays.asList("Java", "JavaScript", "Python", "C", "C++", "Kotlin");
        Map<Character, List<String>> groupedStrings = strings.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

        assertTrue(groupedStrings.containsKey('J'));
        assertTrue(groupedStrings.get('J').containsAll(Arrays.asList("Java", "JavaScript")));
    }

    @Test
    public void testCountOccurrences() throws IOException, URISyntaxException {
        // Assuming that sample.txt exists and it contains the word 'Java' 3 times
        URL url = getClass().getClassLoader().getResource("sample.txt");
        Path path = Paths.get(url.toURI());
        long count = Files.lines(path)
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .filter(word -> word.equals("Java"))
                .count();
        assertEquals(3, count);
    }

    @Test
    public void testSortedProducts() {
        List<StreamOperations.Product> products = Arrays.asList(
                new StreamOperations.Product("Phone", 700, "Electronics"),
                new StreamOperations.Product("TV", 1500, "Electronics"),
                new StreamOperations.Product("Shirt", 50, "Clothing"),
                new StreamOperations.Product("Headphones", 200, "Electronics")
        );

        List<StreamOperations.Product> sortedProducts = products.stream()
                .filter(p -> p.getCategory().equals("Electronics"))
                .sorted(Comparator.comparingDouble(StreamOperations.Product::getPrice))
                .collect(Collectors.toList());

        assertEquals(3, sortedProducts.size());
        assertEquals("Headphones", sortedProducts.get(0).getName());
        assertEquals("Phone", sortedProducts.get(1).getName());
        assertEquals("TV", sortedProducts.get(2).getName());
    }

    @Test
    public void testTotalRevenue() {
        List<StreamOperations.Order> orders = Arrays.asList(
                new StreamOperations.Order(1, 700, "Completed"),
                new StreamOperations.Order(2, 1500, "Pending"),
                new StreamOperations.Order(3, 50, "Completed"),
                new StreamOperations.Order(4, 200, "Completed")
        );

        // Calculate total revenue of completed orders
        double totalRevenue = orders.stream()
                .filter(o -> o.getStatus().equals("Completed"))
                .mapToDouble(StreamOperations.Order::getTotal)
                .sum();

        assertEquals(950, totalRevenue, 0.01);
    }
}
