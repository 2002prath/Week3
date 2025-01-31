package Hashing;

import java.util.HashMap;

public class TwoSum {
    // Method to find two indices such that their values sum to the target
    public static int[] twoSum(int[] nums, int target) {
        // Create a hash map to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement (target - current number)
            int complement = target - nums[i];

            // If complement exists in the map, return the indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };  // return pair of indices
            }

            // Store the current number and its index in the map
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array (or handle as per problem requirement)
        return new int[] {};
    }

    public static void main(String[] args) {
        // Example array and target sum
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Call the method to get the result
        int[] result = twoSum(nums, target);

        // Output the result
        if (result.length > 0) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }
    }
}

