package isp.lab2.Exercise6WordGuess;

import java.util.Random;
import java.util.Scanner;

public class Exercise6WordGuess {

    // Method to count the number of occurrences of a character in a word
    public static int countOccurence(char c, char[] word) {
        int count = 0;
        for (char letter : word) {
            if (letter == c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Array of words to guess from
        String[] words = {"computer", "java", "programming", "language", "algorithm", "data"};

        // Generate a random index to select a word from the array
        Random random = new Random();
        int wordIndex = random.nextInt(words.length);

        // The word to guess
        String wordToGuess = words[wordIndex];

        // Array to store the letters that have been guessed so far
        char[] guessedLetters = new char[wordToGuess.length()];

        // Initialize the guessed letters array to contain underscores
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        // The number of tries the user has taken so far
        int numTries = 0;

        // Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Loop until the user guesses the word or exceeds the maximum number of tries
        while (numTries < 10) {
            // Print the current state of the guessed letters
            System.out.println("Guessed letters: " + String.valueOf(guessedLetters));

            // Prompt the user to enter a letter
            System.out.print("Enter a letter: ");
            char letter = scanner.next().charAt(0);

            // Check if the letter is in the word
            int count = countOccurence(letter, wordToGuess.toCharArray());

            if (count > 0) {
                // The letter is in the word
                System.out.println("The letter is in the word!");
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == letter) {
                        guessedLetters[i] = letter;
                    }
                }
            } else {
                // The letter is not in the word
                System.out.println("The letter is not in the word.");
                numTries++;
            }

            // Check if the user has guessed the entire word
            if (String.valueOf(guessedLetters).equals(wordToGuess)) {
                System.out.println("Congratulations, you guessed the word!");
                System.out.println("Number of tries: " + numTries);
                return;
            }
        }

        // The user has exceeded the maximum number of tries
        System.out.println("You have exceeded the maximum number of tries!");
        System.out.println("The word was: " + wordToGuess);
    }
}

