package Stack;

import java.util.*;

public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] num, int k) {
        if (num == null || k <= 0) return new int[0];

        int n = num.length;
        int[] result = new int[n - k + 1]; // Output array
        Deque<Integer> deque = new LinkedList<>(); // Store indices

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of this window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements from the back if they are smaller than the current element
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                deque.pollLast();
            }

            // Add current element at the back of deque
            deque.offer(i);

            // Store the max element of the current window in the result
            if (i >= k - 1) {
                result[i - k + 1] = num[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}

