package Hashing;

import java.util.*;

public class ZeroSum {

    // Function to find all subarrays with zero sum
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0; // Initialize cumulative sum

        // Add base case for sum=0 at index -1
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update cumulative sum

            // If sum is already in the map, it means we found a zero-sum subarray
            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(Arrays.asList(start + 1, i)); // Store the subarray indices
                }
            }

            // Store the index for this cumulative sum
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result; // Return list of subarray index pairs
    }

    // Driver function to test the method
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<List<Integer>> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero Sum Subarrays (start index, end index):");
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }
    }
}

