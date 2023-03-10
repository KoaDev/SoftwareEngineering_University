package isp.lab2.Exercise4StringSearch;

import java.util.Scanner;

public class Exercise4StringSearch {
    /**
     * This method should return an array of strings that contain the substring.
     * @param input the string to search in
     * @param substring what to search for
     * @return an array of strings that contain the substring
     */
    public static String[] searchSubstrings(String input, String substring) {
        String[] result = new String[0];
        String[] words = input.split(",");
        for (String word : words) {
            if (word.contains(substring)) {
                String[] temp = new String[result.length + 1];
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = word;
                result = temp;
            }
        }
        return result;
    }

    public static String readFromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter line: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        String input = "apples,computer,bread,tea,car";
        String substring = "te";
        String[] result = searchSubstrings(input, substring);
        for (String string : result) {
            System.out.println(string);
        }
    }
}
