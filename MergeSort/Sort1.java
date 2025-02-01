package MergeSort;
    import java.util.Arrays;

public class Sort1 {

            public static void mergeSort(double[] prices, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2; // Find the middle index

                // Recursively divide the array into two halves
                mergeSort(prices, left, mid);
                mergeSort(prices, mid + 1, right);

                // Merge the sorted halves
                merge(prices, left, mid, right);
            }
        }

        // Merge Function to combine sorted halves
        public static void merge(double[] prices, int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            // Create temporary arrays
            double[] leftArray = new double[n1];
            double[] rightArray = new double[n2];

            // Copy data into temp arrays
            System.arraycopy(prices, left, leftArray, 0, n1);
            System.arraycopy(prices, mid + 1, rightArray, 0, n2);

            // Merge the temp arrays back into the original array
            int i = 0, j = 0, k = left;

            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    prices[k++] = leftArray[i++];
                } else {
                    prices[k++] = rightArray[j++];
                }
            }

            // Copy any remaining elements
            while (i < n1) {
                prices[k++] = leftArray[i++];
            }
            while (j < n2) {
                prices[k++] = rightArray[j++];
            }
        }

        public static void main(String[] args) {
            double[] bookPrices = {499.99, 299.50, 150.00, 699.99, 399.75, 250.25};

            System.out.println("Before Sorting: " + Arrays.toString(bookPrices));
            mergeSort(bookPrices, 0, bookPrices.length - 1);
            System.out.println("After Sorting: " + Arrays.toString(bookPrices));
        }
    }


