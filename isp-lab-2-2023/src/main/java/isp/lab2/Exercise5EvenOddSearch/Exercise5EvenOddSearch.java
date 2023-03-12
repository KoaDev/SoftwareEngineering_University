package isp.lab2.Exercise5EvenOddSearch;

import java.util.Arrays;

public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(String input) {
        String[] numsStr = input.split(","); // 5, 2, 4, 7, 3, 8, 1, 6
        int[] nums = new int[numsStr.length]; // 8
        for (int i = 0; i < numsStr.length; i++) { // 0, 1, 2, 3, 4, 5, 6, 7
            nums[i] = Integer.parseInt(numsStr[i]);  // 5, 2, 4, 7, 3, 8, 1, 6
        }

        int largestEven = Integer.MIN_VALUE; // 8
        int smallestOdd = Integer.MAX_VALUE; // 1
        int largestEvenIndex = -1; // 5
        int smallestOddIndex = -1;  // 6

        for (int i = 0; i < nums.length; i++) { // 0, 1, 2, 3, 4, 5, 6, 7
            int num = nums[i]; // 5, 2, 4, 7, 3, 8, 1, 6
            if (num % 2 == 0) {
                if (num > largestEven) {
                    largestEven = num;
                    largestEvenIndex = i;
                }
            } else {
                if (num < smallestOdd) {
                    smallestOdd = num;
                    smallestOddIndex = i;
                }
            }
        }

        // show results
        if (largestEvenIndex == -1) {
            System.out.println("No even numbers in the list");
        } else {
            System.out.println("Largest even number: " + largestEven + " at position " + largestEvenIndex);
        }

        if (smallestOddIndex == -1) {
            System.out.println("No odd numbers in the list");
        } else {
            System.out.println("Smallest odd number: " + smallestOdd + " at position " + smallestOddIndex);
        }

        // Return the results as an array
        return new int[] {largestEven, largestEvenIndex, smallestOdd, smallestOddIndex};
    }


    public static void main(String[] args) {
        String input = "1,2,3,4,5,6,7,8,9,10";
        int[] result = findEvenOdd(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
