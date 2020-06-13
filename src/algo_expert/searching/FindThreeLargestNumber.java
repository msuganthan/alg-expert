package algo_expert.searching;

/**
 * Write a function that takes in an array of integers and without sorting the input array,
 * returns a sorted array of the three largest integers in the input array.
 */
public class FindThreeLargestNumber {
    static int[] findThreeLargestNumbers(int[] array) {
        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num: array)
            updateLargest(threeLargest, num);
        return threeLargest;
    }

    static void updateLargest(int[] threeLargest, int num) {
        if (num > threeLargest[2])
            shiftAndUpdate(threeLargest, num, 2);
        else if (num > threeLargest[1])
            shiftAndUpdate(threeLargest, num, 1);
        else if (num > threeLargest[0])
            shiftAndUpdate(threeLargest, num, 0);
    }

    static void shiftAndUpdate(int[] threeLargest, int num, int idx) {
        for (int i = 0; i <= idx; i++) {
            if (i == idx)
                threeLargest[i] = num;
            else
                threeLargest[i] = threeLargest[i + 1];
        }
    }
}
