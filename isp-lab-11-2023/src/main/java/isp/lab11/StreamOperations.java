package isp.lab11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {

    public static void main(String[] args) throws IOException {
        // List of strings
        List<String> strings = Arrays.asList("Java", "JavaScript", "Python", "C", "C++", "Kotlin");

        // Find the length of the longest string
        Optional<String> longestString = strings.stream()
                .max(Comparator.comparingInt(String::length));
        longestString.ifPresent(s -> System.out.println("Longest String: " + s));

        // List of integers
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Find the sum of all even numbers
        int sum = integers.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of even numbers: " + sum);

        // Convert a list of strings to uppercase
        List<String> uppercaseStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase Strings: " + uppercaseStrings);

        // Group a list of words by their first letter
        Map<Character, List<String>> groupedStrings = strings.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("Grouped Strings: " + groupedStrings);

        // Count the number of occurrences of a word in a text file
        String wordToFind = "Java";
        long count = Files.lines(Paths.get("sample.txt"))
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .filter(word -> word.equals(wordToFind))
                .count();
        System.out.println("Count of '" + wordToFind + "': " + count);

        // Suppose we have a class called Product
        List<Product> products = Arrays.asList(
                new Product("Phone", 700, "Electronics"),
                new Product("TV", 1500, "Electronics"),
                new Product("Shirt", 50, "Clothing"),
                new Product("Headphones", 200, "Electronics")
        );

        // Filter and sort products
        List<Product> sortedProducts = products.stream()
                .filter(p -> p.getCategory().equals("Electronics"))
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
        System.out.println("Sorted Products: " + sortedProducts);

        // Suppose we have a class called Order
        List<Order> orders = Arrays.asList(
                new Order(1, 700, "Completed"),
                new Order(2, 1500, "Pending"),
                new Order(3, 50, "Completed"),
                new Order(4, 200, "Completed")
        );

        // Calculate total revenue of completed orders
        double totalRevenue = orders.stream()
                .filter(o -> o.getStatus().equals("Completed"))
                .mapToDouble(Order::getTotal)
                .sum();
        System.out.println("Total Revenue: " + totalRevenue);
    }

    static class Product {
        private String name;
        private double price;
        private String category;

        public Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", category='" + category + '\'' +
                    '}';
        }
    }

    static class Order {
        private int id;
        private double total;
        private String status;

        public Order(int id, double total, String status) {
            this.id = id;
            this.total = total;
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public double getTotal() {
            return total;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "id=" + id +
                    ", total=" + total +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}
