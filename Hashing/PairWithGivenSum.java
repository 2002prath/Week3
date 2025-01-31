package Hashing;

import java.util.*;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : arr) {
            int complement = target - num; // Find the required pair value
            if (seenNumbers.contains(complement)) {
                return true; // Pair found
            }
            seenNumbers.add(num); // Add current number to set
        }

        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        System.out.println("Pair exists: " + hasPairWithSum(arr, target));
    }
}

