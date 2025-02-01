package CountingSort;
    import java.util.Arrays;

public class Sort1 {


        public static void countingSort(int[] ages, int minAge, int maxAge) {
            int range = maxAge - minAge + 1;  // Range of ages (9 values: 10-18)
            int[] count = new int[range];     // Count array to store frequency
            int[] output = new int[ages.length]; // Output array for sorted ages

            // Step 1: Count occurrences of each age
            for (int age : ages) {
                count[age - minAge]++; // Adjust index by subtracting minAge (10)
            }

            // Step 2: Compute cumulative frequency
            for (int i = 1; i < range; i++) {
                count[i] += count[i - 1];
            }

            // Step 3: Place elements in sorted order (traverse from right for stability)
            for (int i = ages.length - 1; i >= 0; i--) {
                int age = ages[i];
                output[count[age - minAge] - 1] = age;  // Place element at correct position
                count[age - minAge]--; // Decrease count for next occurrence
            }

            // Step 4: Copy sorted elements back to original array
            System.arraycopy(output, 0, ages, 0, ages.length);
        }

        public static void main(String[] args) {
            int[] studentAges = {12, 15, 10, 18, 12, 16, 14, 13, 12, 17, 15, 10, 16};

            System.out.println("Before Sorting: " + Arrays.toString(studentAges));
            countingSort(studentAges, 10, 18);
            System.out.println("After Sorting: " + Arrays.toString(studentAges));
        }
    }


