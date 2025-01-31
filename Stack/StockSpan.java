package Stack;

import java.util.Stack;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];  // Store spans
        Stack<Integer> stack = new Stack<>(); // Store indices

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and price[stack.top] <= price[i]
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, it means no greater element on the left
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push the current index to stack
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        // Print the result
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
