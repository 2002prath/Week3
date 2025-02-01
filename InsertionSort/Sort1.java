package InsertionSort;

    import java.util.Arrays;  // Import Arrays class for printing the array


public class Sort1 {

        public static void insertionSort(int[] arr) {
            int n = arr.length;

            for (int i = 1; i < n; i++) {
                int key = arr[i];  // Pick the current element
                int j = i - 1;


                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }

                arr[j + 1] = key;  // Place the key at its correct position
            }
        }

        public static void main(String[] args) {
            int[] employeeIDs = {103, 101, 105, 102, 104}; // Unsorted Employee IDs

            System.out.println("Before Sorting: " + Arrays.toString(employeeIDs));
            insertionSort(employeeIDs); // Sort the Employee IDs
            System.out.println("After Sorting: " + Arrays.toString(employeeIDs));
        }
    }


