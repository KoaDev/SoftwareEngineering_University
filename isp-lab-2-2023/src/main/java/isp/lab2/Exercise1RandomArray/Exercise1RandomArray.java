package isp.lab2.Exercise1RandomArray;

import java.util.Random;

public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers(int n) {
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(91) + 10; // generate a random number between 0 and 99
        }
        return array;
    }
    public static int[] findMaxAndMin(int[] array) {
        int[] mm = new int[2]; // mm[0] will store min, mm[1] will store max
        mm[0] = array[0]; // initialize min and max to first element
        mm[1] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < mm[0]) {
                mm[0] = array[i]; // update min
            } else if (array[i] > mm[1]) {
                mm[1] = array[i]; // update max
            }
        }
        return mm;
    }

    public static void main(String[] args) {

        Random random = new Random();

        //genereaza numar random intre 10 si 100
        int size = random.nextInt(91) + 10;
        int[] a = getArrayOfRandomNumbers(size);
        int[] mm = findMaxAndMin(a);
        System.out.println("Min is:"+mm[0]+" Max is:"+mm[1] );
    }
}
