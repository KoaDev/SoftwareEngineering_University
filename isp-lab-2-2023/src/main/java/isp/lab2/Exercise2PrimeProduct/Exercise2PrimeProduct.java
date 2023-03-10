package isp.lab2.Exercise2PrimeProduct;

import java.util.Scanner;

public class Exercise2PrimeProduct {

    /**
     * This method should return the product of the first n prime numbers
     * @param n the number of prime numbers
     * @param m the number of prime numbers
     * @return the product of the first n prime numbers
     */
    public static long getPrimeProduct(int n, int m) {
        long product = 1; // the product of the first n prime numbers
        int count = 0; // the number of prime numbers found
        int number = 2; // the first prime number
        while (count < m) { // while the number of prime numbers found is less than m
            if (isPrime(number)) { // if the number is prime
                count++; // increment the number of prime numbers found
                if (count >= n) { // if the number is in the range
                    product *= number; // multiply the product with the number
                }
            }
            number++; // increment the number
        }
        return product;
    }

    /**
     * This method should return true if the number is prime
     * @param number the number to check
     * @return true if the number is prime
     */
    public static boolean isPrime(int number) {
        if (number <= 1) { // 1 is not prime
            return false;
        }
        for (int i = 2; i < number; i++) { // check if the number is divisible by any number less than it
            if (number % i == 0) { // if the number is divisible by i
                return false;
            }
        }
        return true;
    }



    /**
     * This method should read from the console a number
     * @return the number read from the console
     */
    public static int readfromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        return number;
    }

    public static void main(String[] args) {
        System.out.println("The product of the first 10 prime numbers is: " + getPrimeProduct(1, 10));
        System.out.println("The product of prime numbers between m and n: " + getPrimeProduct(readfromConsoleInt(), readfromConsoleInt()));
    }

}
