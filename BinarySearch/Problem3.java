package BinarySearch;

public class Problem3 {

        public static boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int rows = matrix.length, cols = matrix[0].length;
            int left = 0, right = rows * cols - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midElement = matrix[mid / cols][mid % cols]; // Convert 1D index to 2D

                if (midElement == target) {
                    return true; // Found target
                } else if (midElement < target) {
                    left = mid + 1; // Search right
                } else {
                    right = mid - 1; // Search left
                }
            }

            return false; // Not found
        }

        public static void main(String[] args) {
            int[][] matrix = {
                    {1, 3, 5},
                    {7, 10, 11},
                    {12, 14, 16}
            };
            int target = 10;

            boolean found = searchMatrix(matrix, target);
            System.out.println("Target found: " + found);
        }
    }


