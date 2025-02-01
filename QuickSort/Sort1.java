package QuickSort;
    import java.util.Arrays;

public class Sort1 {


        public static void quickSort(double[] prices, int low, int high) {
            if (low < high) {
                // Get the pivot index
                int pivotIndex = partition(prices, low, high);

                // Recursively sort the left and right subarrays
                quickSort(prices, low, pivotIndex - 1);
                quickSort(prices, pivotIndex + 1, high);
            }
        }

        // Partition Function
        public static int partition(double[] prices, int low, int high) {
            double pivot = prices[high]; // Choosing the last element as the pivot
            int i = low - 1; // Pointer for the smaller element

            for (int j = low; j < high; j++) {
                if (prices[j] < pivot) { // If current element is smaller than pivot
                    i++;
                    // Swap prices[i] and prices[j]
                    double temp = prices[i];
                    prices[i] = prices[j];
                    prices[j] = temp;
                }
            }

            // Swap the pivot element to its correct position
            double temp = prices[i + 1];
            prices[i + 1] = prices[high];
            prices[high] = temp;

            return i + 1; // Return the pivot index
        }

        public static void main(String[] args) {
            double[] productPrices = {199.99, 99.50, 150.00, 499.99, 349.75, 250.25};

            System.out.println("Before Sorting: " + Arrays.toString(productPrices));
            quickSort(productPrices, 0, productPrices.length - 1);
            System.out.println("After Sorting: " + Arrays.toString(productPrices));
        }
    }


