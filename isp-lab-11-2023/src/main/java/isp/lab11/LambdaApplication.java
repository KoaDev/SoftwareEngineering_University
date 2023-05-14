package isp.lab11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaApplication {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Use BiConsumer interface to add integers to list
        BiConsumer<List<Integer>, Integer> addToList = (l, i) -> l.add(i);

        // Use Function interface to retrieve an integer from list
        Function<List<Integer>, Integer> getFromList = (l) -> {
            System.out.println("Enter index:");
            int index = scanner.nextInt();
            return l.get(index);
        };

        // Use Consumer interface to print the size of the list
        Consumer<List<Integer>> printSize = (l) -> System.out.println("Size: " + l.size());

        boolean running = true;
        while (running) {
            System.out.println("1. Add integer\n2. Get integer\n3. Print size\n4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter integer:");
                    int input = scanner.nextInt();
                    addToList.accept(list, input);
                    break;
                case 2:
                    try {
                        System.out.println("Retrieved: " + getFromList.apply(list));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index");
                    }
                    break;
                case 3:
                    printSize.accept(list);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }
}
