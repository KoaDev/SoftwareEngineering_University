package lab.template;

import java.util.Random;
import java.util.Scanner;

/**
 *  Sample code demonstrating some basic functions of Java.
 *  @author mihai.hulea
 */
public class Samples {

    public static void randomNumber(){
        // creează un obiect Random
        Random rand = new Random();

        // generează un număr întreg aleatoriu între 0 și 99
        int randomNumber = rand.nextInt(100);
        // afișează numărul întreg aleatoriu generat
        System.out.println("Numarul intreg aleatoriu generat este: " + randomNumber);

        //genereaza 10 numere aleatorii
        for (int i = 0; i < 10; i++) {
            randomNumber = rand.nextInt(100);
            System.out.println("Numarul intreg aleatoriu generat este: " + randomNumber);
        }

    }

    public static void readIntegerFromConsole(){
        Scanner scanner = new Scanner(System.in);

        // citirea unui număr întreg de la consolă
        System.out.print("Introduceti un numar intreg: ");
        int number = scanner.nextInt();

        // afișarea numărului citit de la consolă
        System.out.println("Numarul citit este: " + number);
    }

    public static void readWordFromConsole(){
        Scanner scanner = new Scanner(System.in);

        // citirea unui șir de caractere de la consolă
        System.out.print("Introduceti un sir de caractere: ");
        String inputString = scanner.nextLine();

        // afișarea șirului de caractere citit de la consolă
        System.out.println("Sirul de caractere citit este: " + inputString);
    }

    public static void createIntVector(){
        // declară un vector de 10 elemente de tip întreg
        int[] vector = new int[10];

        // inițializează vectorul cu valori crescătoare de la 1 la 10
        for (int i = 0; i < vector.length; i++) {
            vector[i] = i + 1;
        }

        // afișează vectorul de întregi
        System.out.print("Vectorul de intregi este: ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
    }

    public static void createAVectorOfChars(){
        Scanner scanner = new Scanner(System.in);

        // citirea unui cuvânt de la consolă
        System.out.print("Introduceti un cuvant: ");
        String cuvant = scanner.nextLine();

        // declararea unui vector de caractere cu dimensiunea egala cu numarul de caractere din cuvant
        char[] vectorCaractere = new char[cuvant.length()];

        // initializarea vectorului de caractere cu caracterele din cuvant
        for (int i = 0; i < cuvant.length(); i++) {
            vectorCaractere[i] = cuvant.charAt(i);
        }

        // afisarea vectorului de caractere
        System.out.print("Vectorul de caractere este: ");
        for (int i = 0; i < vectorCaractere.length; i++) {
            System.out.print(vectorCaractere[i] + " ");
        }
    }

    public static void stringTokenizer(){
        String inputString = "ana,ion,maria,dan";

        // separă șirul de caractere utilizând virgula drept separator
        String[] tokens = inputString.split(",");

        // afișează fiecare cuvânt separat din șirul de caractere
        System.out.println("Cuvintele din șirul de caractere sunt:");
        for (String token : tokens) {
            System.out.println(token);
        }
    }

    public static void convertStringToInteger(){
        String inputString = "123";

        // converteste șirul de caractere într-un număr întreg
        int number = Integer.parseInt(inputString);

        // afișează numărul întreg
        System.out.println("Numarul intreg este: " + number);
    }

    public static void searchForSubstring(){
        String inputString = "Acesta este un exemplu de șir de caractere";
        String substring = "exemplu";

        // căutarea substring-ului în șirul de caractere
        if (inputString.contains(substring)) {
            System.out.println("Substring-ul \"" + substring + "\" a fost găsit în șirul de caractere.");
        } else {
            System.out.println("Substring-ul \"" + substring + "\" nu a fost găsit în șirul de caractere.");
        }
    }

    public static void createAVecotOfStrings(){
        Scanner scanner = new Scanner(System.in);

        // citirea dimensiunii vectorului de șiruri de caractere de la consolă
        System.out.print("Introduceti dimensiunea vectorului: ");
        int dimensiune = scanner.nextInt();
        scanner.nextLine(); // se consumă caracterul Enter

        // declararea vectorului de șiruri de caractere și inițializarea acestuia cu șiruri citite de la consolă
        String[] vectorStrings = new String[dimensiune];
        for (int i = 0; i < dimensiune; i++) {
            System.out.print("Introduceti un sir de caractere: ");
            vectorStrings[i] = scanner.nextLine();
        }

        // afișarea vectorului de șiruri de caractere
        System.out.print("Vectorul de siruri de caractere este: ");
        for (int i = 0; i < dimensiune; i++) {
            System.out.print(vectorStrings[i] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("It works!");
        randomNumber();
        readIntegerFromConsole();
        readWordFromConsole();
        createIntVector();
        createAVectorOfChars();
        stringTokenizer();
        convertStringToInteger();
        searchForSubstring();
        createAVecotOfStrings();
    }

}
