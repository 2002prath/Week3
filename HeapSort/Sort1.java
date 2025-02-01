package HeapSort;
    import java.util.Arrays;

public class Sort1 {



        // Heap Sort function
        public static void heapSort(int[] salaries) {
            int n = salaries.length;

            // Step 1: Build Max Heap
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(salaries, n, i);
            }

            // Step 2: Extract elements from heap one by one
            for (int i = n - 1; i > 0; i--) {
                // Swap root (max element) with last element
                int temp = salaries[0];
                salaries[0] = salaries[i];
                salaries[i] = temp;

                // Heapify root to maintain max heap property
                heapify(salaries, i, 0);
            }
        }

        // Heapify function to maintain max heap property
        public static void heapify(int[] arr, int n, int i) {
            int largest = i;      // Assume root is largest
            int left = 2 * i + 1; // Left child index
            int right = 2 * i + 2; // Right child index

            // If left child is larger than root
            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }

            // If right child is larger than largest so far
            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            // If largest is not root, swap and heapify
            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;

                // Recursively heapify the affected sub-tree
                heapify(arr, n, largest);
            }
        }

        public static void main(String[] args) {
            int[] salaries = {55000, 42000, 67000, 80000, 59000, 48000};

            System.out.println("Before Sorting: " + Arrays.toString(salaries));
            heapSort(salaries);
            System.out.println("After Sorting: " + Arrays.toString(salaries));
        }
    }


